package com.danylokharutonovvvuaa.habit_tracker.presentation.base

interface Reducer<UiState, UiEvent> {
    fun reduce(state: UiState, event: UiEvent) : UiState
}