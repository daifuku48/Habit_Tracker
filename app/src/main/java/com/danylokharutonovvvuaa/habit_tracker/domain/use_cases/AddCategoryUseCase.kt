package com.danylokharutonovvvuaa.habit_tracker.domain.use_cases

import com.danylokharutonovvvuaa.habit_tracker.domain.model.CategoryDomain
import com.danylokharutonovvvuaa.habit_tracker.domain.repository.HabitsRepository
import javax.inject.Inject

class AddCategoryUseCase @Inject constructor(
    private val repository: HabitsRepository
) {

    suspend fun execute(categoryDomain: CategoryDomain){
        repository.addCategory(categoryDomain)
    }
}