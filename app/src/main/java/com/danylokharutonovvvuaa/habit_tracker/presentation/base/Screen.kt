package com.danylokharutonovvvuaa.habit_tracker.presentation.base

sealed class Screen(val route: String){
    object SplashScreen : Screen("splash_screen")
    object HomeScreen : Screen("home_screen")
    object AddCategory : Screen("add_category")
    object AddHabit : Screen("add_habit")
    object AnalyticsScreen : Screen("analytics_screen")

    object SettingsScreen : Screen("settings_screen")
}