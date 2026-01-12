package com.example.mealmanager.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealmanager.data.MealRepository
import com.example.mealmanager.data.local.Deposit
import com.example.mealmanager.data.local.MealRecord
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject

data class MealSummary(
    val totalMeals: Int = 0,
    val totalCost: Double = 0.0,
    val totalDeposited: Double = 0.0,
    val currentBalance: Double = 0.0,
    val mealRate: Double = 0.0
)

@HiltViewModel
class MealViewModel @Inject constructor(
    private val repository: MealRepository
) : ViewModel() {

    private val _mealRate = MutableStateFlow(0.0)
    val mealRate = _mealRate.asStateFlow()

    init {
        viewModelScope.launch {
            _mealRate.value = repository.getMealRate()
        }
    }

    val mealRecords: Flow<List<MealRecord>> = repository.getAllMealRecords()
    val deposits: Flow<List<Deposit>> = repository.getAllDeposits()

    val summary: Flow<MealSummary> = combine(
        mealRecords,
        deposits,
        mealRate
    ) { records, deposits, rate ->
        val totalMeals = records.sumOf { it.count }
        val totalCost = totalMeals * rate
        val totalDeposited = deposits.sumOf { it.amount }
        MealSummary(
            totalMeals = totalMeals,
            totalCost = totalCost,
            totalDeposited = totalDeposited,
            currentBalance = totalDeposited - totalCost,
            mealRate = rate
        )
    }

    fun updateMealCount(date: Long, count: Int) {
        viewModelScope.launch {
            repository.insertMealRecord(MealRecord(date, count))
        }
    }

    fun addDeposit(amount: Double) {
        viewModelScope.launch {
            repository.insertDeposit(Deposit(date = System.currentTimeMillis(), amount = amount))
        }
    }

    fun setMealRate(rate: Double) {
        viewModelScope.launch {
            _mealRate.value = rate
            repository.setMealRate(rate)
        }
    }

    fun deleteDeposit(deposit: Deposit) {
        viewModelScope.launch {
            repository.deleteDeposit(deposit)
        }
    }

    fun resetAllData() {
        viewModelScope.launch {
            repository.deleteAllMealRecords()
            repository.deleteAllDeposits()
            repository.setMealRate(0.0)
            _mealRate.value = 0.0
        }
    }
}
