package com.danylokharutonovvvuaa.habit_tracker.domain.use_cases.home_screen

import com.danylokharutonovvvuaa.habit_tracker.domain.model.HabitDomain
import com.danylokharutonovvvuaa.habit_tracker.domain.repository.HabitsRepository
import com.danylokharutonovvvuaa.habit_tracker.presentation.base.UseCase
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.HomeEvent
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.HomeState
import javax.inject.Inject

class UpdateHabitIsFinishedToday @Inject constructor(
    private val repository: HabitsRepository
) : UseCase<HomeState, HomeEvent> {
    suspend fun execute(habitDomain: HabitDomain){
        repository.updateHabit(habitDomain)
    }

    override suspend fun execute(state: HomeState, event: HomeEvent): HomeEvent {
        TODO("Not yet implemented")
    }

    override fun canHandle(event: HomeEvent): Boolean {
        return event is HomeEvent.UpdateHabitEvent
    }
}