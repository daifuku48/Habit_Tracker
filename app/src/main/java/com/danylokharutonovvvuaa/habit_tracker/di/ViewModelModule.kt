package com.danylokharutonovvvuaa.habit_tracker.di

import com.danylokharutonovvvuaa.habit_tracker.presentation.base.UseCase
import com.danylokharutonovvvuaa.habit_tracker.presentation.base.navigation.Navigator
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.HomeEvent
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.HomeScreenReducer
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.HomeScreenViewModel
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.HomeState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object ViewModelModule {

    @Provides
    fun providesHomeScreenReducer() : HomeScreenReducer {
        return HomeScreenReducer()
    }

    @Provides
    fun providesHomeScreenViewModel(
        navigator: Navigator,
        reducer: HomeScreenReducer,
        list: List<UseCase<HomeState, HomeEvent>>
    ): HomeScreenViewModel {
        return HomeScreenViewModel(
            reducer = reducer,
            useCases = list,
            appNavigator = navigator
        )
    }
}