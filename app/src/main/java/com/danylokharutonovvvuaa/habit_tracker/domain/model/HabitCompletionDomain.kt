package com.danylokharutonovvvuaa.habit_tracker.domain.model

import com.danylokharutonovvvuaa.habit_tracker.data.room.entities.HabitCompletionEntity

data class HabitCompletionDomain(
    var id: Long = 0,
    var habitId: Long,
    var date: String,
    var isFinished: Boolean
)

fun HabitCompletionDomain.toEntity() : HabitCompletionEntity {
    return HabitCompletionEntity(
        id = id,
        habitId = habitId,
        date = date,
        isFinished = isFinished
    )
}