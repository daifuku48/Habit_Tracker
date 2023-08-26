package com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danylokharutonovvvuaa.habit_tracker.domain.model.CategoryDomain
import com.danylokharutonovvvuaa.habit_tracker.domain.model.HabitDomain
import com.danylokharutonovvvuaa.habit_tracker.domain.repository.HabitsRepository
import com.danylokharutonovvvuaa.habit_tracker.domain.repository.SharedDataRepository
import com.danylokharutonovvvuaa.habit_tracker.domain.use_cases.GetAllCategoriesUseCase
import com.danylokharutonovvvuaa.habit_tracker.domain.use_cases.GetAllHabitsUseCase
import com.danylokharutonovvvuaa.habit_tracker.domain.use_cases.GetCompletedHabitsUseCase
import com.danylokharutonovvvuaa.habit_tracker.domain.use_cases.GetHabitsByCategoryUseCase
import com.danylokharutonovvvuaa.habit_tracker.domain.use_cases.UpdateHabitIsFinishedToday
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject


@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
    private val getHabitsByCategoryUseCase: GetHabitsByCategoryUseCase,
    private val getAllHabitsUseCase: GetAllHabitsUseCase,
    private val updateHabitIsFinishedToday: UpdateHabitIsFinishedToday,
    private val sharedDataRepository: SharedDataRepository,
    private val getCompletedHabitsUseCase: GetCompletedHabitsUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val categories : MutableState<List<CategoryDomain>> = mutableStateOf(ArrayList())
    val habits : MutableState<List<HabitDomain>> = mutableStateOf(ArrayList())
    private val currentCategory: MutableState<CategoryDomain?> = mutableStateOf(null)
    val isAllCategory = mutableStateOf(false)
    val completedPercentOfHabits : MutableState<Float> = mutableStateOf(0f)
    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                val result = getAllCategoriesUseCase.execute()
                categories.value = result
            } catch (_: Exception) {

            }

            try {
                val result = getAllHabitsUseCase.execute()
                habits.value = result
            } catch (_: Exception) {

            }

            isAllCategory.value = true
        }
    }

    fun getAllHabits() {
        viewModelScope.launch {
            try {
                val result = getAllHabitsUseCase.execute()
                habits.value = result
            } catch (_: Exception) {

            }

            isAllCategory.value = true
        }
    }

    fun setCurrentCategory(item: CategoryDomain) {
        val index = categories.value.indexOf(item)
        currentCategory.value = categories.value[index]
        viewModelScope.launch {
            habits.value = getHabitsByCategoryUseCase.execute(categories.value[index])
            isAllCategory.value = false
        }
    }

    fun saveCategoryId() {
        currentCategory.value?.id?.let { sharedDataRepository.setCategoryId(it) }
    }

    private fun getHabitsByCategory(){
        if (currentCategory.value != null){
            viewModelScope.launch {
                habits.value = getHabitsByCategoryUseCase.execute(currentCategory.value!!)
            }
        }
    }

    fun updateHabit(habit: HabitDomain){
        val index = habits.value.indexOf(habit)
        viewModelScope.launch {
            updateHabitIsFinishedToday.execute(habits.value[index])

            habits.value = habits.value.toMutableList().apply {
                this[index] = this[index].copy(isFinishedToday = !this[index].isFinishedToday)
            }
        }
    }

    fun getCompletedHabits() {
        viewModelScope.launch {
            completedPercentOfHabits.value = getCompletedHabitsUseCase.execute()
            Log.d("count", completedPercentOfHabits.value.toString())
        }
    }

    companion object{
        const val STATE_RECIPE = "STATE_RECIPE"
    }
}