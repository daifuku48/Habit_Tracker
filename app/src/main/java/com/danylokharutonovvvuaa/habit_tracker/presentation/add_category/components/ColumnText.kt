package com.danylokharutonovvvuaa.habit_tracker.presentation.add_category.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.danylokharutonovvvuaa.habit_tracker.R

@Composable
fun ColumnText(text: String){
    Text(
        text,
        fontFamily = FontFamily(Font(R.font.notosans_bold)),
        fontSize = 18.sp
    )
}