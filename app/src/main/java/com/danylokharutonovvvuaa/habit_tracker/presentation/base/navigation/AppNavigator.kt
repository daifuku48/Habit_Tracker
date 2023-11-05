package com.danylokharutonovvvuaa.habit_tracker.presentation.base.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions

class AppNavigator : Navigator{
    private var _navController : NavController? = null
    val navController
        get() = _navController!!

    override fun attach(navController: NavController) {
        _navController = navController
    }

    override fun navigateTo(destination: String, navOptions: NavOptions?) {
        navController.navigate(destination, navOptions)
    }

    override fun pop() {
        navController.popBackStack()
    }

    override fun detach() {
        _navController = null
    }
}