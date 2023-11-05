package com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen

import com.danylokharutonovvvuaa.habit_tracker.presentation.base.Reducer

class HomeScreenReducer : Reducer<HomeState, HomeEvent> {
    override fun reduce(state: HomeState, event: HomeEvent): HomeState {
        return when (event) {
            is HomeEvent.AllCategoriesIsReceivedEvent -> state.copy(categoriesList = event.categoryList)
            is HomeEvent.HabitsIsReceivedEvent -> state.copy(habitList = event.habitList)
            is HomeEvent.CategoriesIsLoadedEvent -> state.copy(isLoadingCategories = true)
            is HomeEvent.GetAllCategoriesEvent -> state.copy(isLoadingHabits = true)
            is HomeEvent.GetAllHabitsEvent -> state
            is HomeEvent.HabitsIsLoadedEvent -> state
            is HomeEvent.ErrorEvent -> state
            is HomeEvent.SetCurrentCategoryEvent -> state.copy(currentCategory = event.categoryDomain)
            is HomeEvent.GetAllHabitsByCategoryEvent -> state
            is HomeEvent.UpdateHabitEvent -> state
            is HomeEvent.HabitIsUpdated -> state.copy(habitList = event.habitList)
            is HomeEvent.GetPercentOfCompletedHabits -> state
            is HomeEvent.PercentOfCompletedHabitsIsReceived -> state.copy(completedPercentHabits = event.percent)
        }
    }
}