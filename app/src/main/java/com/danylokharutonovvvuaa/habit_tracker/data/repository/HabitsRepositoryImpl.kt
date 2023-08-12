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
    override fun getAllHabitsFromCategory(id: Long): List<HabitDomain> {
        val list = habitsDao.getHabitsByCategories(id)
        val domainList = mutableListOf<HabitDomain>()
        for (item in list){
            domainList.add(habitsMapper.entityToDomain(item))
        }
        return domainList
    }

    override fun getAllCategories(): List<CategoryDomain> {
        val list = habitsDao.getAllCategories()
        val domainList = mutableListOf<CategoryDomain>()
        for (item in list){
            domainList.add(categoryMapper.entityToDomain(item))
        }
        return domainList
    }

    override fun addCategory(categoryDomain: CategoryDomain) {
        habitsDao.insertCategory(categoryMapper.domainToEntity(categoryDomain))
    }

    override fun addHabit(habitDomain: HabitDomain) {
        habitsDao.insertHabit(habitsMapper.domainToEntity(habitDomain))
    }

    override fun deleteCategory(categoryDomain: CategoryDomain) {
        habitsDao.deleteCategory(categoryMapper.domainToEntity(categoryDomain))
    }

    override fun deleteHabit(habitDomain: HabitDomain) {
        habitsDao.deleteHabit(habitsMapper.domainToEntity(habitDomain))
    }

    override fun updateCategory(categoryDomain: CategoryDomain) {
        habitsDao.updateCategories(categoryMapper.domainToEntity(categoryDomain))
    }

    override fun updateHabit(habitDomain: HabitDomain) {
        habitsDao.updateHabit(habitsMapper.domainToEntity(habitDomain))
    }
}