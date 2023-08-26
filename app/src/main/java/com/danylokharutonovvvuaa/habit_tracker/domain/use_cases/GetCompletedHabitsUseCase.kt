package com.danylokharutonovvvuaa.habit_tracker.domain.use_cases

import com.danylokharutonovvvuaa.habit_tracker.domain.repository.HabitsRepository
import javax.inject.Inject

class GetCompletedHabitsUseCase @Inject constructor(
    private val repository: HabitsRepository
) {
    suspend fun execute() : Float {
        var countOfCompleted = 0f
        val habitsList = repository.getAllHabits()
        for (item in habitsList){
            if (item.isFinishedToday)
                countOfCompleted += 1f
        }
        return countOfCompleted / habitsList.size
    }
}