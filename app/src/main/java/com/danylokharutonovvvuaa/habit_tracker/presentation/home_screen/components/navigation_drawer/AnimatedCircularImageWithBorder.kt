package com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.components.navigation_drawer

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.danylokharutonovvvuaa.habit_tracker.R
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.HomeScreenViewModel
import com.danylokharutonovvvuaa.habit_tracker.presentation.ui.theme.Purple80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimatedCircularImageWithBorder(
    vm: HomeScreenViewModel,
    drawerState: DrawerState
) {
    vm.getCompletedHabits()
    val animatedProgress = animateFloatAsState(
        targetValue = if (drawerState.isOpen) vm.completedPercentOfHabits.value else 0f,
        animationSpec = tween(
            durationMillis = if (drawerState.isOpen) 1500 else 1,
            easing = LinearEasing
        ), label = ""
    ).value


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Purple80)
            .padding(),
        contentAlignment = Alignment.Center
    ) {

        Canvas(
            modifier = Modifier
                .size(90.dp)
                .border(
                    width = 2.dp,
                    color = Color.Gray,
                    shape = CircleShape
                )
        ){}

        Canvas(
            modifier = Modifier
                .size(88.dp)
                .background(Color.Transparent)
                .border(
                    width = 3.dp,
                    color = Color.Transparent,
                    shape = CircleShape
                )
        ){
            val sweepAngle = animatedProgress * 360
            drawArc(
                color = Color.Red,
                startAngle = -90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(width = 10f)
            )
        }

        Image(
            painter = painterResource(id = R.drawable.logo_compose),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )
    }
}