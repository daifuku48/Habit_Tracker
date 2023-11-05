package com.danylokharutonovvvuaa.habit_tracker.presentation.activities

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.danylokharutonovvvuaa.habit_tracker.presentation.add_category.AddCategoryScreen
import com.danylokharutonovvvuaa.habit_tracker.presentation.add_category.AddCategoryViewModel
import com.danylokharutonovvvuaa.habit_tracker.presentation.add_habit.AddHabitScreen
import com.danylokharutonovvvuaa.habit_tracker.presentation.add_habit.AddHabitScreenViewModel
import com.danylokharutonovvvuaa.habit_tracker.presentation.analytics_screen.AnalyticsScreen
import com.danylokharutonovvvuaa.habit_tracker.presentation.analytics_screen.AnalyticsScreenViewModel
import com.danylokharutonovvvuaa.habit_tracker.presentation.base.Screen
import com.danylokharutonovvvuaa.habit_tracker.presentation.base.Screen.Companion.HOME_SCREEN
import com.danylokharutonovvvuaa.habit_tracker.presentation.base.navigation.AppNavigator
import com.danylokharutonovvvuaa.habit_tracker.presentation.base.navigation.Navigator
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.HomeScreen
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.HomeScreenViewModel
import com.danylokharutonovvvuaa.habit_tracker.presentation.settings_screen.SettingsScreen
import com.danylokharutonovvvuaa.habit_tracker.presentation.settings_screen.SettingsScreenViewModel
import com.danylokharutonovvvuaa.habit_tracker.presentation.splash_screen.SplashScreen
import com.danylokharutonovvvuaa.habit_tracker.presentation.splash_screen.SplashScreenViewModel
import com.danylokharutonovvvuaa.habit_tracker.presentation.ui.theme.Habit_TrackerTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject lateinit var navigator: Navigator
    @OptIn(ExperimentalMaterial3Api::class)
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Habit_TrackerTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {

                    composable(route = Screen.HomeScreen.route) {
                        val entry = remember(it) {
                            navController.getBackStackEntry(Screen.HomeScreen.route)
                        }
                        val homeVM = hiltViewModel<HomeScreenViewModel>(entry)
                        HomeScreen(navController = navController, vm = homeVM)
                    }

                    composable(route = Screen.AddCategory.route) {
                        val entry = remember(it) {
                            navController.getBackStackEntry(Screen.AddCategory.route)
                        }
                        val addCategoryVM = hiltViewModel<AddCategoryViewModel>(entry)
                        AddCategoryScreen(navController = navController, vm = addCategoryVM)
                    }

                    composable(route = Screen.AddHabit.route) {
                        val entry = remember(it) {
                            navController.getBackStackEntry(Screen.AddHabit.route)
                        }
                        val addHabitVM = hiltViewModel<AddHabitScreenViewModel>(entry)
                        AddHabitScreen(
                            navController = navController,
                            addHabitScreenViewModel = addHabitVM
                        )
                    }

                    composable(route = Screen.AnalyticsScreen.route) {
                        val entry = remember(it) {
                            navController.getBackStackEntry(Screen.AnalyticsScreen.route)
                        }
                        val analyticsVM = hiltViewModel<AnalyticsScreenViewModel>(entry)
                        AnalyticsScreen(navController = navController, vm = analyticsVM)
                    }

                    composable(route = Screen.SettingsScreen.route) {
                        val entry = remember(it) {
                            navController.getBackStackEntry(Screen.SettingsScreen.route)
                        }
                        val settingsVM = hiltViewModel<SettingsScreenViewModel>(entry)
                        SettingsScreen(navController = navController, vm = settingsVM)
                    }
                }
            }
        }
    }

    companion object {
        const val SHIMMER_ITEMS = "SHIMMER_ITEMS"
    }
}