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
    fun insertCategory(categoriesEntity: CategoryEntity)

    @Update
    fun updateCategories(categoriesEntity: CategoryEntity)

    @Insert
    fun insertHabit(habitEntity: HabitEntity)

    @Update
    fun updateHabit(habitEntity: HabitEntity)

    @Query("SELECT * FROM CATEGORIES_TABLE")
    fun getAllCategories() : List<CategoryEntity>

    @Query("SELECT * FROM CATEGORIES_TABLE WHERE id == :id")
    fun getHabitsByCategories(id: Long) : List<HabitEntity>

    @Delete
    fun deleteHabit(habitEntity: HabitEntity)

    @Delete
    fun deleteCategory(categoryEntity: CategoryEntity)
}