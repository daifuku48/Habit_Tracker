package com.danylokharutonovvvuaa.habit_tracker.domain.use_cases

import com.danylokharutonovvvuaa.habit_tracker.domain.model.CategoryDomain
import com.danylokharutonovvvuaa.habit_tracker.domain.repository.HabitsRepository
import javax.inject.Inject

class GetAllCategoriesUseCase @Inject constructor(
    private val repository: HabitsRepository
) {
    suspend fun execute() : List<CategoryDomain>{
        return repository.getAllCategories()
    }
}