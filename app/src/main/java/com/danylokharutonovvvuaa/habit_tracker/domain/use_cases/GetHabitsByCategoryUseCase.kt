package com.danylokharutonovvvuaa.habit_tracker.domain.use_cases

import com.danylokharutonovvvuaa.habit_tracker.domain.model.CategoryDomain
import com.danylokharutonovvvuaa.habit_tracker.domain.model.HabitDomain
import com.danylokharutonovvvuaa.habit_tracker.domain.repository.HabitsRepository
import javax.inject.Inject

class GetHabitsByCategoryUseCase @Inject constructor(
    private val repository: HabitsRepository
){
    suspend fun execute(category: CategoryDomain) : List<HabitDomain>{
        return repository.getAllHabitsFromCategory(category.id)
    }
}