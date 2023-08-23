package com.danylokharutonovvvuaa.habit_tracker.data.room.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "habit_completion_table",
    foreignKeys = [
    ForeignKey(
        entity = HabitEntity::class,
        parentColumns = ["id"],
        childColumns = ["habitId"],
        onDelete = ForeignKey.CASCADE),
], indices = [
Index(value = ["habitId"])
])
data class HabitCompletionEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var habitId: Long,
    var date: String,
    var isFinished: Boolean
)