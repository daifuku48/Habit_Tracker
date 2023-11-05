package com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen

import com.danylokharutonovvvuaa.habit_tracker.domain.model.CategoryDomain
import com.danylokharutonovvvuaa.habit_tracker.domain.model.HabitDomain
import com.danylokharutonovvvuaa.habit_tracker.presentation.base.UiState
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class HomeState(
    val categoriesList: PersistentList<CategoryDomain> = persistentListOf(),
    val habitList: PersistentList<HabitDomain> = persistentListOf(),
    val isLoadingHabits: Boolean = true,
    val isLoadingCategories: Boolean = true,
    val currentCategory: CategoryDomain? = null,
    val completedPercentHabits: Float = 0.0f
) : UiState