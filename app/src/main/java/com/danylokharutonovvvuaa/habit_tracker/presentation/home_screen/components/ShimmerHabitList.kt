package com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.components

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

@Composable
fun ShimmerHabitList(
    isLoading: Boolean,
    contentAfterLoading: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    if (isLoading){
        Column(modifier = modifier){
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .size(width = 300.dp, height = 40.dp)
                    .shimmerEffectForHabit()
            )
        }
    } else {
        contentAfterLoading()
    }
}

fun Modifier.shimmerEffectForHabit(): Modifier = composed {
    var size by remember{
        mutableStateOf(IntSize.Zero)
    }
    val transition = rememberInfiniteTransition(label = "")
    val startOffSetX by transition.animateFloat(
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),
        animationSpec = infiniteRepeatable(
            tween(2000)
        ), label = ""
    )
    background(
        brush = Brush.linearGradient(
            colors = listOf(
                Color(0xF3F3F3F),
                Color(0xF8B8B8B),
                Color(0xFBBBBBB)
            ),
            start = Offset(startOffSetX, 0f),
            end = Offset(startOffSetX + size.width.toFloat(), size.height.toFloat())
        )
    )
        .onGloballyPositioned {
            size = it.size
        }
}