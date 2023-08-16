package com.danylokharutonovvvuaa.habit_tracker.data.repository

import com.danylokharutonovvvuaa.habit_tracker.data.room.dao.HabitsDao
import com.danylokharutonovvvuaa.habit_tracker.data.room.mappers.CategoryMapper
import com.danylokharutonovvvuaa.habit_tracker.data.room.mappers.HabitsMapper
import com.danylokharutonovvvuaa.habit_tracker.domain.model.CategoryDomain
import com.danylokharutonovvvuaa.habit_tracker.domain.model.HabitDomain
import com.danylokharutonovvvuaa.habit_tracker.domain.repository.HabitsRepository
import javax.inject.Inject

class HabitsRepositoryImpl @Inject constructor(
    private val habitsDao: HabitsDao,
    private val categoryMapper: CategoryMapper,
    private val habitsMapper: HabitsMapper
) : HabitsRepository {
    override suspend fun getAllHabitsFromCategory(id: Long): List<HabitDomain> {
        val list = habitsDao.getHabitsByCategory(id)
        val domainList = mutableListOf<HabitDomain>()
        for (item in list){
            domainList.add(habitsMapper.entityToDomain(item))
        }
        return domainList
    }

    override suspend fun getAllCategories(): List<CategoryDomain> {
        val list = habitsDao.getAllCategories()
        val domainList = mutableListOf<CategoryDomain>()
        for (item in list){
            domainList.add(categoryMapper.entityToDomain(item))
        }
        return domainList
    }

    override suspend fun getAllHabits(): List<HabitDomain> {
        val list = habitsDao.getAllHabits()
        val domainList = mutableListOf<HabitDomain>()
        for (item in list){
            domainList.add(habitsMapper.entityToDomain(item))
        }
        return domainList
    }

    override suspend fun addCategory(categoryDomain: CategoryDomain) {
        habitsDao.insertCategory(categoryMapper.domainToEntity(categoryDomain))
    }

    override suspend fun addHabit(habitDomain: HabitDomain) {
        habitsDao.insertHabit(habitsMapper.domainToEntity(habitDomain))
    }

    override suspend fun deleteCategory(categoryDomain: CategoryDomain) {
        habitsDao.deleteCategory(categoryMapper.domainToEntity(categoryDomain))
    }

    override suspend fun deleteHabit(habitDomain: HabitDomain) {
        habitsDao.deleteHabit(habitsMapper.domainToEntity(habitDomain))
    }

    override suspend fun updateCategory(categoryDomain: CategoryDomain) {
        habitsDao.updateCategories(categoryMapper.domainToEntity(categoryDomain))
    }

    override suspend fun updateHabit(habitDomain: HabitDomain) {
        habitsDao.updateHabit(habitsMapper.domainToEntity(habitDomain))
    }
}