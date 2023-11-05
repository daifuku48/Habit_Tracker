package com.danylokharutonovvvuaa.habit_tracker.data.repository

import com.danylokharutonovvvuaa.habit_tracker.data.room.dao.HabitsDao
import com.danylokharutonovvvuaa.habit_tracker.data.room.entities.toDomain
import com.danylokharutonovvvuaa.habit_tracker.domain.model.CategoryDomain
import com.danylokharutonovvvuaa.habit_tracker.domain.model.HabitDomain
import com.danylokharutonovvvuaa.habit_tracker.domain.model.toEntity
import com.danylokharutonovvvuaa.habit_tracker.domain.repository.HabitsRepository
import javax.inject.Inject

class HabitsRepositoryImpl @Inject constructor(
    private val habitsDao: HabitsDao
) : HabitsRepository {
    override suspend fun getAllHabitsFromCategory(id: Long): List<HabitDomain> {
        return habitsDao.getHabitsByCategory(id).map { it.toDomain() }
    }

    override suspend fun getAllCategories(): List<CategoryDomain> {
        return habitsDao.getAllCategories().map { it.toDomain() }
    }

    override suspend fun getAllHabits(): List<HabitDomain> {
        return habitsDao.getAllHabits().map { it.toDomain() }
    }

    override suspend fun addCategory(categoryDomain: CategoryDomain) {
        habitsDao.insertCategory(categoryDomain.toEntity())
    }

    override suspend fun addHabit(habitDomain: HabitDomain) {
        habitsDao.insertHabit(habitDomain.toEntity())
        val category = getCategoryById(habitDomain.categoryId)
        category.countOfActivities = category.countOfActivities + 1
        habitsDao.updateCategory(category.toEntity())
    }

    override suspend fun deleteCategory(categoryDomain: CategoryDomain) {
        habitsDao.deleteCategory(categoryDomain.toEntity())
    }

    override suspend fun deleteHabit(habitDomain: HabitDomain) {
        habitsDao.deleteHabit(habitDomain.toEntity())
    }

    override suspend fun updateCategory(categoryDomain: CategoryDomain) {
        habitsDao.updateCategory(categoryDomain.toEntity())
    }

    override suspend fun updateHabit(habitDomain: HabitDomain) {
        habitsDao.updateHabit(habitDomain.toEntity())
    }

    override suspend fun getCategoryById(id: Long): CategoryDomain {
        return habitsDao.getCategoryById(id).toDomain()
    }
}