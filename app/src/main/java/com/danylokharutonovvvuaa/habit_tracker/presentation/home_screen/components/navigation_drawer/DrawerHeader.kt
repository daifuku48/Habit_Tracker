package com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.components.navigation_drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.HomeScreenViewModel
import com.danylokharutonovvvuaa.habit_tracker.presentation.ui.theme.Purple80


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerHeader(
    completedPercent: Float,
    drawerState: DrawerState
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                end = 70.dp
            )
            .background(Purple80),
        contentAlignment = Alignment.Center,
    ){
        Column {
            Spacer(Modifier.height(20.dp))
            AnimatedCircularImageWithBorder(completedPercentOfHabits = completedPercent, drawerState = drawerState)
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                text = "Habit tracker",
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontSize = 24.sp
            )
            Spacer(Modifier.height(20.dp))
        }

    }
}

