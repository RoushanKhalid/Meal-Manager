package com.example.mealmanager.data

import com.example.mealmanager.data.local.Deposit
import com.example.mealmanager.data.local.MealDao
import com.example.mealmanager.data.local.MealRecord
import com.example.mealmanager.data.local.Setting
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MealRepository @Inject constructor(
    private val mealDao: MealDao
) {
    fun getAllMealRecords(): Flow<List<MealRecord>> = mealDao.getAllMealRecords()

    suspend fun insertMealRecord(record: MealRecord) = mealDao.insertMealRecord(record)

    fun getAllDeposits(): Flow<List<Deposit>> = mealDao.getAllDeposits()

    suspend fun insertDeposit(deposit: Deposit) = mealDao.insertDeposit(deposit)

    suspend fun deleteDeposit(deposit: Deposit) = mealDao.deleteDeposit(deposit)

    suspend fun getMealRate(): Double {
        return mealDao.getSetting("meal_rate")?.value?.toDoubleOrNull() ?: 0.0
    }

    suspend fun setMealRate(rate: Double) {
        mealDao.insertSetting(Setting("meal_rate", rate.toString()))
    }

    suspend fun deleteAllMealRecords() = mealDao.deleteAllMealRecords()

    suspend fun deleteAllDeposits() = mealDao.deleteAllDeposits()
}
