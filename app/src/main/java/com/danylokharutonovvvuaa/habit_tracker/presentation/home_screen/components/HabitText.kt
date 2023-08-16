package com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danylokharutonovvvuaa.habit_tracker.R


@Composable
fun HabitText() {
    Text(
        text = "Today`s Habits",
        fontSize = 25.sp,
        color = Color.Gray,
        modifier = Modifier.padding(
            start = 5.dp,
            top = 10.dp,
            bottom = 10.dp
        ),
        fontFamily = FontFamily(Font(R.font.notosans_bold))
    )
}