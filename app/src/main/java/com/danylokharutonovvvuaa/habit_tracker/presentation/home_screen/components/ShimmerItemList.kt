package com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.components

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
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

@Composable
fun ShimmerItemList(
    isLoading: Boolean,
    contentAfterLoading: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {

}

fun Modifier.shimmerEffect(): Modifier = composed {
    var size by remember{
        mutableStateOf(IntSize.Zero)
    }
    val transition = rememberInfiniteTransition()
    val startOffSetX by transition.animateFloat(
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),
        animationSpec = infiniteRepeatable(
            tween(2000)
        ), label = ""
    )
    background(
        brush = Brush.verticalGradient(
            colors = listOf(
                Color(0xFF3F3F3),
                Color(0xFB9B9B9),
                Color(0xF7A7A7A)
            ),
            startY = startOffSetX,
            endY = startOffSetX + size.width.toFloat()
        )
    )
        .onGloballyPositioned {
            size = it.size
        }
}