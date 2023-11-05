package com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.danylokharutonovvvuaa.habit_tracker.R
import com.danylokharutonovvvuaa.habit_tracker.presentation.activities.MainActivity.Companion.SHIMMER_ITEMS
import com.danylokharutonovvvuaa.habit_tracker.presentation.base.Screen
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.components.categories.CategoriesItemsList
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.components.categories.CategoriesText
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.components.categories.ShimmerCategoryItemList
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.components.habits.HabitText
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.components.habits.HabitsList
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.components.habits.ShimmerHabitList
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.components.navigation_drawer.DrawerBody
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.components.navigation_drawer.DrawerHeader
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.components.navigation_drawer.MenuItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(
    navController: NavController, vm: HomeScreenViewModel
) {
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var isLoadingCategories by remember {
        mutableStateOf(true)
    }

    var isLoadingHabits by remember {
        mutableStateOf(true)
    }

    LaunchedEffect(key1 = SHIMMER_ITEMS) {
        delay(2000L)
        isLoadingCategories = false
        delay(1000L)
        isLoadingHabits = false
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            Column {
                DrawerHeader(drawerState = drawerState, vm = vm)
                DrawerBody(
                    listItem = listOf(
                        MenuItem(0, stringResource(R.string.home), Icons.Default.Home),
                        MenuItem(1, stringResource(R.string.analytics), Icons.Default.Star),
                        MenuItem(2, stringResource(R.string.settings), Icons.Default.Settings)
                    ),
                    scope = coroutineScope,
                    onItemClick = {
                        when (it.id) {
                            0 -> navController.navigate(Screen.HomeScreen.route)
                            1 -> navController.navigate(Screen.AnalyticsScreen.route)
                            2 -> navController.navigate(Screen.SettingsScreen.route)
                        }
                    }
                )
            }
        }) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = stringResource(R.string.good_habits)
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(
                                painter = painterResource(
                                    id = R.drawable.baseline_dehaze_24
                                ),
                                contentDescription = null
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = {

                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.notification),
                                contentDescription = null
                            )
                        }
                    }
                )
            },

            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    CategoriesText()
                    ShimmerCategoryItemList(isLoading = isLoadingCategories,
                        contentAfterLoading = {
                            CategoriesItemsList(vm = vm, navController = navController)
                        })
                    HabitText()
                    ShimmerHabitList(isLoading = isLoadingHabits,
                        contentAfterLoading = {
                            HabitsList(vm = vm, navController = navController)
                        }
                    )
                }
            }
        )
    }
}



