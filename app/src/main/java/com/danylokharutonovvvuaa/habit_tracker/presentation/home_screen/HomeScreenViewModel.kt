package com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danylokharutonovvvuaa.habit_tracker.domain.model.CategoryDomain
import com.danylokharutonovvvuaa.habit_tracker.domain.model.HabitDomain
import com.danylokharutonovvvuaa.habit_tracker.domain.repository.HabitsRepository
import com.danylokharutonovvvuaa.habit_tracker.domain.use_cases.GetAllCategoriesUseCase
import com.danylokharutonovvvuaa.habit_tracker.domain.use_cases.GetAllHabitsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

const val STATE_RECIPE = "STATE_RECIPE"


@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
    private val getAllHabitsUseCase: GetAllHabitsUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val categories : MutableState<List<CategoryDomain>> = mutableStateOf(ArrayList())
    val habits : MutableState<List<HabitDomain>> = mutableStateOf(ArrayList())

    init {
        fetchCategories()
    }
    private fun fetchCategories(){
        viewModelScope.launch {
            try{
                val result = getAllCategoriesUseCase.execute()
                categories.value = result
            } catch (_: Exception){

            }

            try {
                val result = getAllHabitsUseCase.execute()
                habits.value = result
            } catch (_: Exception){

            }
        }
    }
}