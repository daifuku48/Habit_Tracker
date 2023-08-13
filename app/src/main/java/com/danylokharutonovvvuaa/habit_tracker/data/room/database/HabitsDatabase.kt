package com.danylokharutonovvvuaa.habit_tracker.data.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.danylokharutonovvvuaa.habit_tracker.data.room.dao.HabitsDao
import com.danylokharutonovvvuaa.habit_tracker.data.room.entities.CategoryEntity
import com.danylokharutonovvvuaa.habit_tracker.data.room.entities.HabitEntity


@Database(entities = [CategoryEntity::class, HabitEntity::class], version = 2, exportSchema = false)
abstract class HabitsDatabase : RoomDatabase(){
    abstract fun habitsDAO(): HabitsDao
}