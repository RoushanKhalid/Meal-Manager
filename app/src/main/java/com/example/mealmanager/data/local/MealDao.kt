package com.example.mealmanager.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MealDao {
    @Query("SELECT * FROM meal_records")
    fun getAllMealRecords(): Flow<List<MealRecord>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMealRecord(record: MealRecord)

    @Query("SELECT * FROM deposits")
    fun getAllDeposits(): Flow<List<Deposit>>

    @Insert
    suspend fun insertDeposit(deposit: Deposit)

    @Delete
    suspend fun deleteDeposit(deposit: Deposit)

    @Query("SELECT * FROM settings WHERE `key` = :key LIMIT 1")
    suspend fun getSetting(key: String): Setting?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSetting(setting: Setting)

    @Query("DELETE FROM meal_records")
    suspend fun deleteAllMealRecords()

    @Query("DELETE FROM deposits")
    suspend fun deleteAllDeposits()
}
