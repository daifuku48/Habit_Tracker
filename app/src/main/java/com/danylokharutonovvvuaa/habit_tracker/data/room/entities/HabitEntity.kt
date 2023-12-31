package com.danylokharutonovvvuaa.habit_tracker.data.room.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Ignore
import androidx.room.Index
import androidx.room.PrimaryKey
import com.danylokharutonovvvuaa.habit_tracker.domain.model.HabitDomain

@Entity(foreignKeys = [ForeignKey(
    entity = CategoryEntity::class,
    parentColumns = ["id"],
    childColumns = ["categoryId"],
    onDelete = ForeignKey.CASCADE),
], indices = [
    Index(value = ["categoryId"])
],
    tableName = "habits_table")
data class HabitEntity(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var categoryId: Long,
    var description: String,
    var isFinishedToday: Boolean
)


fun HabitEntity.toDomain() : HabitDomain {
    return HabitDomain(
        id = id,
        categoryId = categoryId,
        description = description,
        isFinishedToday = isFinishedToday
    )
}