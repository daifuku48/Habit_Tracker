package com.danylokharutonovvvuaa.habit_tracker.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.danylokharutonovvvuaa.habit_tracker.data.room.entities.CategoryEntity
import com.danylokharutonovvvuaa.habit_tracker.data.room.entities.HabitEntity

@Dao
interface HabitsDao {
    @Insert
    suspend fun insertCategory(categoriesEntity: CategoryEntity)

    @Update
    suspend fun updateCategories(categoriesEntity: CategoryEntity)

    @Insert
    suspend fun insertHabit(habitEntity: HabitEntity)

    @Update
    suspend fun updateHabit(habitEntity: HabitEntity)

    @Query("SELECT * FROM CATEGORIES_TABLE")
    suspend fun getAllCategories() : List<CategoryEntity>

    @Query("SELECT * FROM habits_table WHERE categoryId = :categoryId")
    suspend fun getHabitsByCategory(categoryId: Long): List<HabitEntity>

    @Delete
    suspend fun deleteHabit(habitEntity: HabitEntity)

    @Delete
    suspend fun deleteCategory(categoryEntity: CategoryEntity)
}