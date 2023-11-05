package com.danylokharutonovvvuaa.habit_tracker.domain.use_cases.home_screen

import com.danylokharutonovvvuaa.habit_tracker.domain.repository.HabitsRepository
import com.danylokharutonovvvuaa.habit_tracker.presentation.base.UseCase
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.HomeEvent
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.HomeState
import kotlinx.collections.immutable.toPersistentList
import javax.inject.Inject

class GetAllCategoriesUseCase @Inject constructor(
    private val repository: HabitsRepository
) : UseCase<HomeState, HomeEvent> {
    override suspend fun execute(state: HomeState, event: HomeEvent): HomeEvent {
        return if (event is HomeEvent.GetAllHabitsEvent) {
            HomeEvent.AllCategoriesIsReceivedEvent(
                categoryList = repository.getAllCategories().toPersistentList()
            )
        } else HomeEvent.GetAllHabitsEvent
    }

    override fun canHandle(event: HomeEvent): Boolean {
        return event is HomeEvent.GetAllCategoriesEvent
    }
}