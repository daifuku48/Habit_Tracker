package com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen

import com.danylokharutonovvvuaa.habit_tracker.domain.model.CategoryDomain
import com.danylokharutonovvvuaa.habit_tracker.domain.model.HabitDomain
import com.danylokharutonovvvuaa.habit_tracker.presentation.base.BaseViewModel
import com.danylokharutonovvvuaa.habit_tracker.presentation.base.Screen
import com.danylokharutonovvvuaa.habit_tracker.presentation.base.UseCase
import com.danylokharutonovvvuaa.habit_tracker.presentation.base.navigation.AppNavigator
import com.danylokharutonovvvuaa.habit_tracker.presentation.base.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    reducer: HomeScreenReducer,
    useCases: List<UseCase<HomeState, HomeEvent>>,
    appNavigator: Navigator,
) : BaseViewModel<HomeEvent, HomeState>(reducer, useCases, appNavigator) {
    init {
        handleFetchCategories()
    }

    private fun handleFetchCategories() {
        handleEvent(HomeEvent.GetAllCategoriesEvent)
    }

    fun handleGetAllHabits() {
        handleEvent(HomeEvent.GetAllHabitsEvent)
    }

    fun setCurrentCategory(item: CategoryDomain) {
        handleEvent(HomeEvent.SetCurrentCategoryEvent(item))
    }

    fun navigateToAddCategory(){
        appNavigator.navigateTo(Screen.AddCategory.route)
    }

    fun navigateToAddHabit(){
        appNavigator.navigateTo(Screen.AddHabit.route)
    }

    fun navigateToSettingsScreen(){
        appNavigator.navigateTo(Screen.SettingsScreen.route)
    }

    fun navigateToAnalyticsScreen(){
        appNavigator.navigateTo(Screen.AnalyticsScreen.route)
    }

    fun navigateToHomeScreen() {
        appNavigator.navigateTo(Screen.HomeScreen.route)
    }

    fun habitIsLoaded(){
        handleEvent(HomeEvent.HabitsIsLoadedEvent)
    }

    fun categoriesIsLoaded(){
        handleEvent(HomeEvent.CategoriesIsLoadedEvent)
    }

    fun addHabit() {
        navigateToAddHabit()
    }
    private fun getHabitsByCategory(){
        handleEvent(HomeEvent.GetAllHabitsByCategoryEvent)
    }

    fun updateHabit(habit: HabitDomain){
        handleEvent(HomeEvent.UpdateHabitEvent(habit))
    }

    fun getCompetedPercentHabits() {
        handleEvent(HomeEvent.GetPercentOfCompletedHabits)
    }

    override fun createInitialState(): HomeState {
        return HomeState()
    }

    override fun handleSpecialEvent(event: HomeEvent) {}
}