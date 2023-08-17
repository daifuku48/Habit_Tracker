package com.danylokharutonovvvuaa.habit_tracker.domain.model

import androidx.room.Embedded
import androidx.room.PrimaryKey
import com.danylokharutonovvvuaa.habit_tracker.data.room.entities.HabitEntity

data class CategoryDomain(
    var id: Long = 0,
    var category: String,
    var countOfActivities: Int,
)