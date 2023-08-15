package com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.danylokharutonovvvuaa.habit_tracker.R
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.components.CategoriesItemsList
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.components.CategoriesText
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.components.HabitsList
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(
    navController: NavController, vm: HomeScreenViewModel
) {
    val coroutineScope = rememberCoroutineScope()
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
                        coroutineScope.launch {

                        }
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.notification),
                            contentDescription = null
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    coroutineScope.launch {

                    }
                },

                ) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.baseline_add_24
                    ),
                    contentDescription = null
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                CategoriesText()
                CategoriesItemsList(vm = vm, navController = navController)
                HabitsList(vm = vm)
            }
        }
    )
}