package com.danylokharutonovvvuaa.habit_tracker.di

import com.danylokharutonovvvuaa.habit_tracker.domain.repository.HabitsRepository
import com.danylokharutonovvvuaa.habit_tracker.domain.use_cases.AddCategoryUseCase
import com.danylokharutonovvvuaa.habit_tracker.domain.use_cases.AddHabitUseCase
import com.danylokharutonovvvuaa.habit_tracker.domain.use_cases.GetAllCategoriesUseCase
import com.danylokharutonovvvuaa.habit_tracker.domain.use_cases.GetAllHabitsUseCase
import com.danylokharutonovvvuaa.habit_tracker.domain.use_cases.GetHabitsByCategoryUseCase
import com.danylokharutonovvvuaa.habit_tracker.domain.use_cases.UpdateHabitIsFinishedToday
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
    fun provideGetAllHabitsUseCase(repository: HabitsRepository): GetAllHabitsUseCase {
        return GetAllHabitsUseCase(repository = repository)
    }


    @Provides
    @Singleton
    fun provideGetAllCategoriesUseCase(repository: HabitsRepository) : GetAllCategoriesUseCase {
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
    fun providesGetHabitsByCategoryUseCase(repository: HabitsRepository) : GetHabitsByCategoryUseCase{
        return GetHabitsByCategoryUseCase(repository = repository)
    }

    @Provides
    @Singleton
    fun providesUpdateHabitIsFinishedToday(repository: HabitsRepository) : UpdateHabitIsFinishedToday {
        return UpdateHabitIsFinishedToday(repository = repository)
    }
}