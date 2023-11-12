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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.danylokharutonovvvuaa.habit_tracker.R
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.HomeScreenViewModel
import com.danylokharutonovvvuaa.habit_tracker.presentation.ui.theme.Purple40


@Composable
fun HabitAddCard(
    navigateToAddHabit:() -> Unit,
    onClickSave: () -> Unit
){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)
        .background(
            color = Purple40,
            shape = RoundedCornerShape(15.dp)
        )
        .border(
            width = 2.dp,
            color = Color.Black,
            shape = RoundedCornerShape(15.dp)
        )
        .clickable {
            onClickSave()
            navigateToAddHabit()
        })
    {
        Text(
            text = "Add Habit",
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(
                    start = 15.dp,
                ),
            fontSize = 20.sp
        )
    }
}