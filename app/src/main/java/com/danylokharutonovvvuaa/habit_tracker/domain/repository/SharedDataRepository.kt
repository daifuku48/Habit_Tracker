package com.danylokharutonovvvuaa.habit_tracker.domain.repository

interface SharedDataRepository {
    fun setCategoryId(id: Long)
    fun getCategoryId() : Long
}