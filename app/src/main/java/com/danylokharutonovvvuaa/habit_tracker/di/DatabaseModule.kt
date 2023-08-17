package com.danylokharutonovvvuaa.habit_tracker.di

import android.content.Context
import androidx.room.Room
import com.danylokharutonovvvuaa.habit_tracker.data.room.dao.HabitsDao
import com.danylokharutonovvvuaa.habit_tracker.data.room.database.HabitsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideHabitsDatabase(@ApplicationContext context: Context) : HabitsDatabase {
        return Room.databaseBuilder(
            context,
            HabitsDatabase::class.java, "habits_db"
        ).allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }


    @Singleton
    @Provides
    fun providesDAO(db: HabitsDatabase) : HabitsDao {
        return db.habitsDAO()
    }
}