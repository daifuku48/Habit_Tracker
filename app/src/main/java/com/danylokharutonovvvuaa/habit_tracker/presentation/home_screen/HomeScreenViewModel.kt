package com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.danylokharutonovvvuaa.habit_tracker.domain.model.CategoryDomain
import com.danylokharutonovvvuaa.habit_tracker.domain.repository.HabitsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: HabitsRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val categories : MutableState<List<CategoryDomain>> = mutableStateOf(ArrayList())

}