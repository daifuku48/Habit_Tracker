package com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danylokharutonovvvuaa.habit_tracker.R
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.HomeScreenViewModel


@Composable
fun HabitsList(
    vm: HomeScreenViewModel
){

    LazyColumn(
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)){
        item{
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

        //items(count){index ->
          //  HabitCard(list[index], vm)
        //}
    }
}
