package com.danylokharutonovvvuaa.habit_tracker.presentation

sealed class Screen(val route: String){
    object SplashScreen : Screen("splash_screen")
    object HomeScreen : Screen("home_screen")
    object AddScreen : Screen("add_screen")
    object AnalyticsScreen : Screen("analytics_screen")
}