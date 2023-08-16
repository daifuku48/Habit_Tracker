package com.danylokharutonovvvuaa.habit_tracker.domain.use_cases

import com.danylokharutonovvvuaa.habit_tracker.domain.model.HabitDomain
import com.danylokharutonovvvuaa.habit_tracker.domain.repository.HabitsRepository
import javax.inject.Inject

class GetAllHabitsUseCase @Inject constructor(
    private val repository: HabitsRepository
){
    suspend fun execute(): List<HabitDomain>{
        return repository.getAllHabits()
    }
}