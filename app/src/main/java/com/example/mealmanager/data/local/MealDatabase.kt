package com.example.mealmanager.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MealRecord::class, Deposit::class, Setting::class], version = 1)
abstract class MealDatabase : RoomDatabase() {
    abstract fun mealDao(): MealDao
}
