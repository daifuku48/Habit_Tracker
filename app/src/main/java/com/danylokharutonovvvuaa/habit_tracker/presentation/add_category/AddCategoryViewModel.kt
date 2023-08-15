package com.danylokharutonovvvuaa.habit_tracker.presentation.add_category

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AddCategoryViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
}