package com.danylokharutonovvvuaa.habit_tracker.di

import com.danylokharutonovvvuaa.habit_tracker.data.repository.HabitsRepositoryImpl
import com.danylokharutonovvvuaa.habit_tracker.data.room.dao.HabitsDao
import com.danylokharutonovvvuaa.habit_tracker.data.room.mappers.CategoryMapper
import com.danylokharutonovvvuaa.habit_tracker.data.room.mappers.HabitsMapper
import com.danylokharutonovvvuaa.habit_tracker.domain.mappers.Mapper
import com.danylokharutonovvvuaa.habit_tracker.domain.repository.HabitsRepository
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
    fun providesCategoriesMapper() : CategoryMapper{
        return CategoryMapper()
    }

    @Provides
    @Singleton
    fun providesHabitsMapper() : HabitsMapper{
        return HabitsMapper()
    }

    @Provides
    @Singleton
    fun providesHabitRepository(
        habitsDao: HabitsDao,
        categoryMapper: CategoryMapper,
        habitsMapper: HabitsMapper
    ) : HabitsRepository {
        return HabitsRepositoryImpl(
            habitsDao = habitsDao,
            categoryMapper = categoryMapper,
            habitsMapper = habitsMapper
        )
    }

}