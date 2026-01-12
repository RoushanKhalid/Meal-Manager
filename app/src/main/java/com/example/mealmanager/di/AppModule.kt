package com.example.mealmanager.di

import android.content.Context
import androidx.room.Room
import com.example.mealmanager.data.local.MealDao
import com.example.mealmanager.data.local.MealDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMealDatabase(@ApplicationContext context: Context): MealDatabase {
        return Room.databaseBuilder(
            context,
            MealDatabase::class.java,
            "meal_manager_db"
        ).build()
    }

    @Provides
    fun provideMealDao(database: MealDatabase): MealDao {
        return database.mealDao()
    }
}
