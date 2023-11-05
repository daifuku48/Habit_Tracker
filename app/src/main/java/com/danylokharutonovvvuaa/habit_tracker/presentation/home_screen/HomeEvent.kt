package com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen

import com.danylokharutonovvvuaa.habit_tracker.domain.model.CategoryDomain
import com.danylokharutonovvvuaa.habit_tracker.domain.model.HabitDomain
import com.danylokharutonovvvuaa.habit_tracker.presentation.base.UiEvent
import kotlinx.collections.immutable.PersistentList

sealed class HomeEvent : UiEvent{
    object GetAllCategoriesEvent: HomeEvent()
    data class AllCategoriesIsReceivedEvent(val categoryList: PersistentList<CategoryDomain>): HomeEvent()
    object GetAllHabitsEvent: HomeEvent()
    data class HabitsIsReceivedEvent(val habitList: PersistentList<HabitDomain>): HomeEvent()
    data class SetCurrentCategoryEvent(val categoryDomain: CategoryDomain): HomeEvent()
    object GetAllHabitsByCategoryEvent: HomeEvent()
    object HabitsIsLoadedEvent: HomeEvent()
    object CategoriesIsLoadedEvent: HomeEvent()
    data class UpdateHabitEvent(val habit: HabitDomain): HomeEvent()
    data class HabitIsUpdated(val habit: HabitDomain): HomeEvent()
    object GetPercentOfCompletedHabits: HomeEvent()
    data class PercentOfCompletedHabitsIsReceived(val percent: Float): HomeEvent()
    object ErrorEvent: HomeEvent()
}
