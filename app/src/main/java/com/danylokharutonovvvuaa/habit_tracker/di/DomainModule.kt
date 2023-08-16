package com.danylokharutonovvvuaa.habit_tracker.di

import com.danylokharutonovvvuaa.habit_tracker.domain.repository.HabitsRepository
import com.danylokharutonovvvuaa.habit_tracker.domain.use_cases.GetAllHabitsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun provideGetAllHabitsUseCase(repository: HabitsRepository): GetAllHabitsUseCase {
        return GetAllHabitsUseCase(habitsRepository = repository)
    }

}