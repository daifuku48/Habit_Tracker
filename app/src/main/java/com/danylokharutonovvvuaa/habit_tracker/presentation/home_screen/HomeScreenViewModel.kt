package com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
}