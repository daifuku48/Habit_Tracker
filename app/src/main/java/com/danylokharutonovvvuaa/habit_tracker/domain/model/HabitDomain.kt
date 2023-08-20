package com.danylokharutonovvvuaa.habit_tracker.domain.model

import androidx.room.PrimaryKey

data class HabitDomain(
    val id: Long,
    val categoryId: Long,
    var description: String,
    var isFinishedToday: Boolean
)