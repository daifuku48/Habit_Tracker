package com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.danylokharutonovvvuaa.habit_tracker.R
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.HomeScreenViewModel


@Composable
fun HabitsList(
    vm: HomeScreenViewModel,
    navController: NavController
){
    val listIsEmpty by remember {
        mutableStateOf(true)
    }
    LazyColumn(
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)){
        if (vm.habits.value.isEmpty()){
            item{
                Box(
                    contentAlignment = Alignment.Center
                ){
                    Text(text = "Habit`s is not exist")
                }
            }

            item{
                HabitAddCard(vm = vm, navController = navController)
            }
        } else
        {
            items(vm.habits.value.size){index ->
                HabitCard(vm.habits.value[index].description, vm)
            }
            item{
                HabitAddCard(vm = vm, navController = navController)
            }
        }

    }
}
