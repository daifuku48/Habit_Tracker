package com.danylokharutonovvvuaa.habit_tracker.data.room.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey


@Entity(tableName = "categories_table")
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var category: String,
    var description: String,
    var countOfActivities: Int
)