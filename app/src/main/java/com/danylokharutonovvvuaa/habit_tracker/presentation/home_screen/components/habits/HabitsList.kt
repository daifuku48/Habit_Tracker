package com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.components.habits

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.danylokharutonovvvuaa.habit_tracker.domain.model.HabitDomain
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.HomeScreenViewModel
import kotlinx.collections.immutable.PersistentList


@Composable
fun HabitsList(
    habitList: PersistentList<HabitDomain>,
    isAllCategory: Boolean,
    navigateToAddHabit: () -> Unit,
    addHabit: () -> Unit,
    updateHabit: (HabitDomain) -> Unit
){
    LazyColumn(
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)){
        if (habitList.isEmpty()){
            item{
                Box(
                    contentAlignment = Alignment.Center
                ){
                    Text(text = "Habit`s is not exist")
                }
            }
            if (!isAllCategory)
            {
                item{
                    HabitAddCard(
                        navigateToAddHabit = {navigateToAddHabit()},
                        onClickSave = {addHabit()}
                    )
                }
            }

        } else
        {
            items(habitList.size){index ->
                val habit = habitList[index]
                key(habit.id) {
                    HabitCard(habit = habit, updateHabit = {updateHabit(it)})
                }
            }
            if (!isAllCategory)
            {
                item{
                    HabitAddCard(
                        navigateToAddHabit = {navigateToAddHabit()},
                        onClickSave = {addHabit()}
                    )
                }
            }
        }
    }
}
