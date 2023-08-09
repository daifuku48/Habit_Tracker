package com.danylokharutonovvvuaa.habit_tracker.presentation.splash_screen

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.danylokharutonovvvuaa.habit_tracker.R
import com.danylokharutonovvvuaa.habit_tracker.presentation.ui.theme.Habit_TrackerTheme
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController, splashScreenViewModel: SplashScreenViewModel){
    Habit_TrackerTheme {
        SplashImageWithAnimation(
            imageId = R.drawable.logo_compose,
            navController = navController
        )
    }
}


@Composable
fun SplashImageWithAnimation(imageId: Int, navController: NavController){
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    // AnimationEffect
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        delay(4000L)
        navController.navigate("home_screen")
    }

    // Image
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = imageId),
            contentDescription = "Logo",
            modifier = Modifier.scale(scale.value))
    }
}