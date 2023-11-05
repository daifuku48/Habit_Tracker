package com.danylokharutonovvvuaa.habit_tracker.presentation.base

sealed class Screen(val route: String) {
    object HomeScreen : Screen(HOME_SCREEN)
    object AddCategory : Screen(ADD_CATEGORY)
    object AddHabit : Screen(ADD_HABIT)
    object AnalyticsScreen : Screen(ANALYTICS_SCREEN)
    object SettingsScreen : Screen(SETTINGS_SCREEN)

    companion object{
        const val HOME_SCREEN = "home_screen"
        const val ADD_CATEGORY = "home_screen"
        const val ADD_HABIT = "add_habit"
        const val ANALYTICS_SCREEN = "analytics_screen"
        const val SETTINGS_SCREEN = "settings_screen"
    }
}