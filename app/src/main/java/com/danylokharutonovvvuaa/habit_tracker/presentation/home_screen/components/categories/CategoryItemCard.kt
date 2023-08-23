package com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.components.categories

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.danylokharutonovvvuaa.habit_tracker.R
import com.danylokharutonovvvuaa.habit_tracker.domain.model.CategoryDomain
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.HomeScreenViewModel
import com.danylokharutonovvvuaa.habit_tracker.presentation.ui.theme.Purple80

@Composable
fun ItemCard(item: CategoryDomain, navController: NavController, vm: HomeScreenViewModel) {

    val count = remember{ mutableStateOf( item.countOfActivities) }

    Box(
        modifier = Modifier
            .padding(8.dp)
            .size(120.dp)
            .background(
                color = Purple80,
                shape = RoundedCornerShape(15.dp)
            ).clickable(onClick = {
                vm.setCurrentCategory(item)
            }),
    ) {
        Column(modifier = Modifier.align(Alignment.CenterStart)) {
            Text(
                text = count.value.toString() + " habits",
                modifier = Modifier.padding(
                    start = 10.dp
                )
            )
            Text(
                text = item.category,
                fontFamily = FontFamily(Font(R.font.notosans_bold)),
                fontSize = 24.sp,
                modifier = Modifier.padding(
                    start = 10.dp
                )
            )
        }
    }
}