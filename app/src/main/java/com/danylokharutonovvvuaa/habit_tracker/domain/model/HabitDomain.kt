package com.danylokharutonovvvuaa.habit_tracker.domain.model

import androidx.room.PrimaryKey
import com.danylokharutonovvvuaa.habit_tracker.data.room.entities.HabitEntity

data class HabitDomain(
    val id: Long,
    val categoryId: Long,
    var description: String,
    var isFinishedToday: Boolean
)

fun HabitDomain.toEntity() : HabitEntity {
    return HabitEntity(
        id = id,
        categoryId = categoryId,
        description = description,
        isFinishedToday = isFinishedToday
    )
}