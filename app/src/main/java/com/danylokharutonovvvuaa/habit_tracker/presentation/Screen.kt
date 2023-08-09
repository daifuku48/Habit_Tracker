package com.danylokharutonovvvuaa.habit_tracker.presentation

sealed class Screen(val route: String){
    object SplashScreen : Screen("splash_screen")
    object HomeScreen : Screen("home_screen")
    object AddHabit : Screen("add_habit")
    object AnalyticsScreen : Screen("analytics_screen")
}