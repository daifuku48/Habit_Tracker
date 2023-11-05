package com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.danylokharutonovvvuaa.habit_tracker.domain.model.CategoryDomain
import com.danylokharutonovvvuaa.habit_tracker.domain.model.HabitDomain
import com.danylokharutonovvvuaa.habit_tracker.presentation.base.BaseViewModel
import com.danylokharutonovvvuaa.habit_tracker.presentation.base.UseCase
import com.danylokharutonovvvuaa.habit_tracker.presentation.base.navigation.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    reducer: HomeScreenReducer,
    useCases: List<UseCase<HomeState, HomeEvent>>,
    appNavigator: AppNavigator,
    private val savedStateHandle: SavedStateHandle
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

//    fun saveCategoryId() {
//        currentCategory.value?.id?.let { sharedDataRepository.setCategoryId(it) }
//    }

    private fun getHabitsByCategory(){
        handleEvent(HomeEvent.GetAllHabitsByCategoryEvent)
    }

    fun updateHabit(habit: HabitDomain){
        handleEvent(HomeEvent.UpdateHabitEvent(habit))
    }

    fun getCompletedHabits() {
        handleEvent()
        viewModelScope.launch {
            completedPercentOfHabits.value = getCompletedHabitsUseCase.execute()
            Log.d("count", completedPercentOfHabits.value.toString())
        }
    }

    override fun createInitialState(): HomeState {
        return HomeState()
    }

    override fun handleSpecialEvent(event: HomeEvent) {}
}