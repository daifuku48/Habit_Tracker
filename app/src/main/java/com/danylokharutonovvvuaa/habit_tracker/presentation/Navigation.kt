package com.danylokharutonovvvuaa.habit_tracker.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.HomeScreenViewModel
import com.danylokharutonovvvuaa.habit_tracker.presentation.ui.theme.Habit_TrackerTheme

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash_screen"){
        composable(route = Screen.SplashScreen.route){
            val entry = remember(it) {
                navController.getBackStackEntry(Screen.HomeScreen.route)
            }
            val tasksVM = hiltViewModel<HomeScreenViewModel>(entry)
            HomeScreen(navController = navController, tasksVM)
        }
    }
}