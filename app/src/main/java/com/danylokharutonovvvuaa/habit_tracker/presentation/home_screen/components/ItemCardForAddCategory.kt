package com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.danylokharutonovvvuaa.habit_tracker.R
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.HomeScreenViewModel
import com.danylokharutonovvvuaa.habit_tracker.presentation.ui.theme.Purple
import com.danylokharutonovvvuaa.habit_tracker.presentation.ui.theme.Purple80



@Composable
fun ItemCardForAddCategory(
    navController: NavController, vm: HomeScreenViewModel
){
    Box(
        modifier = Modifier
            .padding(8.dp)
            .size(120.dp)
            .border(
                width = 4.dp,
                color = Purple,
                shape = RoundedCornerShape(15.dp)
            )
            .background(
                color = androidx.compose.ui.graphics.Color.White,
                shape = RoundedCornerShape(15.dp)
            ).clickable(onClick = {})
    ){
        Image(
            painter = painterResource(id = R.drawable.baseline_add_category),
            contentDescription = "add category",
            modifier = Modifier
                .align(Alignment.Center)
                .size(60.dp)
        )
    }
}

