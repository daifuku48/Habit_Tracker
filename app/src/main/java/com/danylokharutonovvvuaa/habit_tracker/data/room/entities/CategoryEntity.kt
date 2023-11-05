package com.danylokharutonovvvuaa.habit_tracker.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.danylokharutonovvvuaa.habit_tracker.domain.model.CategoryDomain


@Entity(tableName = "categories_table")
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var category: String,
    var countOfActivities: Int
)

fun CategoryEntity.toDomain(): CategoryDomain {
    return CategoryDomain(
        id = id,
        category = category,
        countOfActivities = countOfActivities
    )
}