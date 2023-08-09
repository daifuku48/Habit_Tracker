package com.danylokharutonovvvuaa.habit_tracker.presentation.splash_screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SplashScreenViewModel@Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
}