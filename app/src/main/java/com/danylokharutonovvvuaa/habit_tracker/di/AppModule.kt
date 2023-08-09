package com.danylokharutonovvvuaa.habit_tracker.di

import android.content.Context
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    fun provideApp(@ApplicationContext context: Context) : Context {
        return context
    }
}