package com.danylokharutonovvvuaa.habit_tracker.presentation.add_habit

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danylokharutonovvvuaa.habit_tracker.domain.model.CategoryDomain
import com.danylokharutonovvvuaa.habit_tracker.domain.model.HabitDomain
import com.danylokharutonovvvuaa.habit_tracker.domain.repository.SharedDataRepository
import com.danylokharutonovvvuaa.habit_tracker.domain.use_cases.AddHabitUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AddHabitScreenViewModel @Inject constructor(
    private val addHabitUseCase: AddHabitUseCase,
    private val sharedDataRepository: SharedDataRepository,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {
    private val habit: MutableState<HabitDomain?> = mutableStateOf(null)

    fun setHabit(description: String){
        habit.value = HabitDomain(
            id = 0,
            categoryId = sharedDataRepository.getCategoryId(),
            description = description,
            isFinishedToday = false
        )
    }

    fun addHabit(){
        viewModelScope.launch {
            addHabitUseCase.execute(
                habit = habit.value as HabitDomain
            )
        }
    }
}