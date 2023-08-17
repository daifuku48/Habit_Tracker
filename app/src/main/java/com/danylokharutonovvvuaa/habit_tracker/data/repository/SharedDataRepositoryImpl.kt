package com.danylokharutonovvvuaa.habit_tracker.data.repository

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.danylokharutonovvvuaa.habit_tracker.domain.repository.SharedDataRepository

class SharedDataRepositoryImpl : SharedDataRepository {

    private val categoryId: MutableState<Long> = mutableStateOf(0)

    override fun setCategoryId(id: Long) {
        categoryId.value = id
    }

    override fun getCategoryId() = categoryId.value
}