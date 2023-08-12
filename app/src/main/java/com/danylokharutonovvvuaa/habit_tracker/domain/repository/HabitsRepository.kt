package com.danylokharutonovvvuaa.habit_tracker.domain.repository

import com.danylokharutonovvvuaa.habit_tracker.domain.model.CategoryDomain
import com.danylokharutonovvvuaa.habit_tracker.domain.model.HabitDomain

interface HabitsRepository {
    fun getAllHabitsFromCategory(id: Long) : List<HabitDomain>
    fun getAllCategories() : List<CategoryDomain>

    fun addCategory(categoryDomain: CategoryDomain)

    fun addHabit(habitDomain: HabitDomain)

    fun deleteCategory(categoryDomain: CategoryDomain)

    fun deleteHabit(habitDomain: HabitDomain)

    fun updateCategory(categoryDomain: CategoryDomain)

    fun updateHabit(habitDomain: HabitDomain)
}