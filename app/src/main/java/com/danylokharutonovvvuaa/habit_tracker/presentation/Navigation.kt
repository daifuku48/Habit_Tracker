package com.danylokharutonovvvuaa.habit_tracker.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.danylokharutonovvvuaa.habit_tracker.presentation.add_habit.AddHabitScreenViewModel
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.HomeScreen
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.HomeScreenViewModel
import com.danylokharutonovvvuaa.habit_tracker.presentation.splash_screen.SplashImageWithAnimation
import com.danylokharutonovvvuaa.habit_tracker.presentation.splash_screen.SplashScreen
import com.danylokharutonovvvuaa.habit_tracker.presentation.splash_screen.SplashScreenViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash_screen"){
        composable(route = Screen.SplashScreen.route){
            val entry = remember(it) {
                navController.getBackStackEntry(Screen.SplashScreen.route)
            }
            val splashVM = hiltViewModel<SplashScreenViewModel>(entry)
            SplashScreen(navController = navController, splashVM)
        }
        composable(route = Screen.HomeScreen.route){
            val entry = remember(it) {
                navController.getBackStackEntry(Screen.HomeScreen.route)
            }
            val homeVM = hiltViewModel<HomeScreenViewModel>(entry)
        }
        composable(route = Screen.AddHabit.route){
            val entry =  remember(it){
                navController.getBackStackEntry(Screen.AddHabit.route)
            }
            val addHabitVM = hiltViewModel<AddHabitScreenViewModel>(entry)
        }
    }
}