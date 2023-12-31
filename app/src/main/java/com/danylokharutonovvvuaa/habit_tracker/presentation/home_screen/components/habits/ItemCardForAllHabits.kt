package com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.components.habits

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.HomeScreenViewModel
import com.danylokharutonovvvuaa.habit_tracker.presentation.ui.theme.Purple


@Composable
fun ItemCardForAllHabits(
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .size(120.dp)
            .border(
                width = 4.dp,
                color = Purple,
                shape = RoundedCornerShape(15.dp)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(15.dp)
            ).clickable(onClick = {
                onClick()
            })
    ) {
        Text(
            text = "All",
            modifier = Modifier
                .align(Alignment.Center),
            fontSize = 32.sp
        )
    }
}
