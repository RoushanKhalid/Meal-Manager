package com.example.mealmanager.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meal_records")
data class MealRecord(
    @PrimaryKey val date: Long, // Epoch milli for the start of the day
    val count: Int
)

@Entity(tableName = "deposits")
data class Deposit(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val date: Long,
    val amount: Double
)

@Entity(tableName = "settings")
data class Setting(
    @PrimaryKey val key: String,
    val value: String
)
