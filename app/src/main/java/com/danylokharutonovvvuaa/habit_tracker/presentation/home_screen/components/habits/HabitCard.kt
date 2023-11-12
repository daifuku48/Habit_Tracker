package com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.components.habits

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danylokharutonovvvuaa.habit_tracker.R
import com.danylokharutonovvvuaa.habit_tracker.domain.model.HabitDomain


@Composable
fun HabitCard(
    habit: HabitDomain,
    updateHabit: (HabitDomain) -> Unit
) {
    val textStyle = TextStyle(
        fontSize = 20.sp,
        fontFamily = FontFamily(Font(R.font.notosans_medium))
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(15.dp)
            )
            .border(
                width = 2.dp,
                color = Color.Black,
                shape = RoundedCornerShape(15.dp)
            )
            .clickable {
                habit.isFinishedToday = !habit.isFinishedToday
                updateHabit(habit)
            }
    ) {
        Text(
            text = habit.description,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 15.dp),
            style = textStyle,
            textDecoration = if (habit.isFinishedToday) TextDecoration.LineThrough else TextDecoration.None // Применяем зачёркивание в зависимости от состояния
        )
    }
}