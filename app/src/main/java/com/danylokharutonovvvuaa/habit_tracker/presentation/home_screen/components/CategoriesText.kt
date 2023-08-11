package com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danylokharutonovvvuaa.habit_tracker.R

@Composable
fun CategoriesText(){
    Text(
        text = stringResource(R.string.categories),
        fontSize = 30.sp,
        color = Color.Black,
        fontFamily = FontFamily(Font(R.font.notosans_bold)),
        modifier = Modifier.padding(
            top = 10.dp,
            start = 20.dp,
            bottom = 10.dp
        )
    )
}