package com.danylokharutonovvvuaa.habit_tracker.domain.utils

import com.danylokharutonovvvuaa.habit_tracker.domain.model.CategoryDomain

class UpdateCountOfActivities {

    companion object{
        fun execute(categoryDomain: CategoryDomain) : CategoryDomain{
            categoryDomain.countOfActivities = categoryDomain.countOfActivities + 1
            return categoryDomain
        }
    }

}