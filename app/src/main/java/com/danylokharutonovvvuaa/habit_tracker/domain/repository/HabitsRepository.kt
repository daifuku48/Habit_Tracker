package com.danylokharutonovvvuaa.habit_tracker.domain.repository

import com.danylokharutonovvvuaa.habit_tracker.domain.model.CategoryDomain
import com.danylokharutonovvvuaa.habit_tracker.domain.model.HabitDomain

interface HabitsRepository {
    suspend fun getAllHabitsFromCategory(id: Long) : List<HabitDomain>
    suspend fun getAllCategories() : List<CategoryDomain>
    suspend fun getAllHabits() : List<HabitDomain>
    suspend fun addCategory(categoryDomain: CategoryDomain)

    suspend fun addHabit(habitDomain: HabitDomain)

    suspend fun deleteCategory(categoryDomain: CategoryDomain)

    suspend fun deleteHabit(habitDomain: HabitDomain)

    suspend fun updateCategory(categoryDomain: CategoryDomain)

    suspend fun updateHabit(habitDomain: HabitDomain)

    suspend fun getCategoryById(id: Long) : CategoryDomain
}