package com.danylokharutonovvvuaa.habit_tracker.domain.use_cases.home_screen

import com.danylokharutonovvvuaa.habit_tracker.domain.model.CategoryDomain
import com.danylokharutonovvvuaa.habit_tracker.domain.model.HabitDomain
import com.danylokharutonovvvuaa.habit_tracker.domain.repository.HabitsRepository
import com.danylokharutonovvvuaa.habit_tracker.presentation.base.UseCase
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.HomeEvent
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.HomeState
import kotlinx.collections.immutable.toPersistentList
import javax.inject.Inject

class GetHabitsByCategoryUseCase @Inject constructor(
    private val repository: HabitsRepository
): UseCase<HomeState, HomeEvent>{
    suspend fun execute(category: CategoryDomain) : List<HabitDomain>{
        return repository.getAllHabitsFromCategory(category.id)
    }

    override suspend fun execute(state: HomeState, event: HomeEvent): HomeEvent {
        return if (event is HomeEvent.GetAllHabitsByCategoryEvent) {
            if (state.currentCategory != null){
                HomeEvent.HabitsIsReceivedEvent(habitList = repository.getAllHabitsFromCategory(state.currentCategory.id).toPersistentList())
            } else HomeEvent.ErrorEvent
        } else HomeEvent.ErrorEvent
    }

    override fun canHandle(event: HomeEvent): Boolean {
        return event is HomeEvent.GetAllHabitsByCategoryEvent
    }
}