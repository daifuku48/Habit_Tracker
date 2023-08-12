package com.danylokharutonovvvuaa.habit_tracker.domain.model

import androidx.room.PrimaryKey

data class HabitDomain(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val categoryId: Long,
    var description: String,
    var isFinishedToday: Boolean
)