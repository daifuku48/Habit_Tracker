package com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.HomeScreenViewModel

@Composable
fun CategoriesItemsList(
    navController: NavController, vm: HomeScreenViewModel
){
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(
            start = 12.dp
        )
    ){
        item{
            ItemCardForAllHabits(
                navController = navController,
                vm = vm
            )
        }

        items(vm.categories.value.size){index ->
            ItemCard(vm.categories.value[index], navController, vm)
        }

        item {
            ItemCardForAddCategory(
                navController = navController,
                vm = vm
            )
        }
    }
}