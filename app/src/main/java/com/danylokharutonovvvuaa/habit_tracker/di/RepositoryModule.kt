package com.danylokharutonovvvuaa.habit_tracker.di

import com.danylokharutonovvvuaa.habit_tracker.data.repository.HabitsRepositoryImpl
import com.danylokharutonovvvuaa.habit_tracker.data.repository.SharedDataRepositoryImpl
import com.danylokharutonovvvuaa.habit_tracker.data.room.dao.HabitsDao
import com.danylokharutonovvvuaa.habit_tracker.domain.repository.HabitsRepository
import com.danylokharutonovvvuaa.habit_tracker.domain.repository.SharedDataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesHabitRepository(
        habitsDao: HabitsDao
    ) : HabitsRepository {
        return HabitsRepositoryImpl(
            habitsDao = habitsDao
        )
    }

    @Provides
    @Singleton
    fun providesSharedDataRepository() : SharedDataRepository {
        return SharedDataRepositoryImpl()
    }
}