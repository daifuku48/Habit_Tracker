package com.danylokharutonovvvuaa.habit_tracker.di

import androidx.fragment.app.FragmentActivity
import com.danylokharutonovvvuaa.habit_tracker.presentation.base.navigation.AppNavigator
import com.danylokharutonovvvuaa.habit_tracker.presentation.base.navigation.Navigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent


@Module
@InstallIn(ActivityComponent::class)
object AppModule {
    @Provides
    fun providesNavigator() : Navigator {
        return AppNavigator()
    }
}