package com.danylokharutonovvvuaa.habit_tracker.presentation.base.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions

interface Navigator {

    fun attach(navController: NavController)

    fun navigateTo(destination: String, navOptions: NavOptions? = null)

    fun pop()

    fun detach()
}