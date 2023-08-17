package com.danylokharutonovvvuaa.habit_tracker.presentation.base

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.danylokharutonovvvuaa.habit_tracker.presentation.add_category.AddCategoryScreen
import com.danylokharutonovvvuaa.habit_tracker.presentation.add_category.AddCategoryViewModel
import com.danylokharutonovvvuaa.habit_tracker.presentation.add_habit.AddHabitScreen
import com.danylokharutonovvvuaa.habit_tracker.presentation.add_habit.AddHabitScreenViewModel
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.HomeScreen
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.HomeScreenViewModel
import com.danylokharutonovvvuaa.habit_tracker.presentation.splash_screen.SplashScreen
import com.danylokharutonovvvuaa.habit_tracker.presentation.splash_screen.SplashScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash_screen"){
        composable(route = Screen.SplashScreen.route){
            val entry = remember(it) {
                navController.getBackStackEntry(Screen.SplashScreen.route)
            }
            val splashVM = hiltViewModel<SplashScreenViewModel>()
            SplashScreen(navController = navController, splashVM)
        }
        composable(route = Screen.HomeScreen.route){
            val entry = remember(it) {
                navController.getBackStackEntry(Screen.HomeScreen.route)
            }
            val homeVM = hiltViewModel<HomeScreenViewModel>(entry)
            HomeScreen(navController = navController, vm = homeVM)
        }
        composable(route = Screen.AddCategory.route){
            val entry = remember(it){
                navController.getBackStackEntry(Screen.AddCategory.route)
            }
            val addCategoryVM = hiltViewModel<AddCategoryViewModel>(entry)
            AddCategoryScreen(navController = navController, vm = addCategoryVM)
        }
        composable(route = Screen.AddHabit.route){
            val entry =  remember(it){
                navController.getBackStackEntry(Screen.AddHabit.route)
            }
            val addHabitVM = hiltViewModel<AddHabitScreenViewModel>(entry)
            AddHabitScreen(navController = navController, addHabitScreenViewModel = addHabitVM)
        }
    }
}