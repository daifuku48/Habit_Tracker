package com.danylokharutonovvvuaa.habit_tracker.domain.use_cases.home_screen

import com.danylokharutonovvvuaa.habit_tracker.domain.repository.HabitsRepository
import com.danylokharutonovvvuaa.habit_tracker.presentation.base.UseCase
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.HomeEvent
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.HomeState
import javax.inject.Inject

class GetCompletedHabitsUseCase @Inject constructor(
    private val repository: HabitsRepository
) : UseCase<HomeState, HomeEvent> {
    suspend fun execute() : Float {
        var countOfCompleted = 0f
        val habitsList = repository.getAllHabits()
        for (item in habitsList){
            if (item.isFinishedToday)
                countOfCompleted += 1f
        }
        return countOfCompleted / habitsList.size
    }

    override suspend fun execute(state: HomeState, event: HomeEvent): HomeEvent {
        TODO("Not yet implemented")
    }

    override fun canHandle(event: HomeEvent): Boolean {
        return event is HomeEvent
    }
}