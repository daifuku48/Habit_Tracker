package com.danylokharutonovvvuaa.habit_tracker.di

import com.danylokharutonovvvuaa.habit_tracker.domain.repository.HabitsRepository
import com.danylokharutonovvvuaa.habit_tracker.domain.use_cases.AddCategoryUseCase
import com.danylokharutonovvvuaa.habit_tracker.domain.use_cases.AddHabitUseCase
import com.danylokharutonovvvuaa.habit_tracker.domain.use_cases.home_screen.GetAllCategoriesUseCase
import com.danylokharutonovvvuaa.habit_tracker.domain.use_cases.home_screen.GetAllHabitsUseCase
import com.danylokharutonovvvuaa.habit_tracker.domain.use_cases.home_screen.GetCompletedHabitsUseCase
import com.danylokharutonovvvuaa.habit_tracker.domain.use_cases.home_screen.GetHabitsByCategoryUseCase
import com.danylokharutonovvvuaa.habit_tracker.domain.use_cases.home_screen.UpdateHabitIsFinishedToday
import com.danylokharutonovvvuaa.habit_tracker.presentation.base.UseCase
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.HomeEvent
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.HomeState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideGetAllHabitsUseCase(repository: HabitsRepository): UseCase<HomeState, HomeEvent> {
        return GetAllHabitsUseCase(repository = repository)
    }


    @Provides
    @Singleton
    fun provideGetAllCategoriesUseCase(repository: HabitsRepository) : UseCase<HomeState, HomeEvent> {
        return GetAllCategoriesUseCase(repository = repository)
    }


    @Provides
    @Singleton
    fun providesAddCategoryUseCase(repository: HabitsRepository) : AddCategoryUseCase{
        return AddCategoryUseCase(repository = repository)
    }

    @Provides
    @Singleton
    fun providesAddHabitUseCase(repository: HabitsRepository) : AddHabitUseCase{
        return AddHabitUseCase(repository = repository)
    }

    @Provides
    @Singleton
    fun providesGetHabitsByCategoryUseCase(repository: HabitsRepository) : UseCase<HomeState, HomeEvent> {
        return GetHabitsByCategoryUseCase(repository = repository)
    }

    @Provides
    @Singleton
    fun providesUpdateHabitIsFinishedToday(repository: HabitsRepository) : UseCase<HomeState, HomeEvent> {
        return UpdateHabitIsFinishedToday(repository = repository)
    }

    @Provides
    @Singleton
    fun providesGetCompletedHabitsUseCase(repository: HabitsRepository) : UseCase<HomeState, HomeEvent> {
        return GetCompletedHabitsUseCase(repository = repository)
    }
}