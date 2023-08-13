package com.danylokharutonovvvuaa.habit_tracker.data.room.mappers

import com.danylokharutonovvvuaa.habit_tracker.data.room.entities.CategoryEntity
import com.danylokharutonovvvuaa.habit_tracker.domain.mappers.Mapper
import com.danylokharutonovvvuaa.habit_tracker.domain.model.CategoryDomain

class CategoryMapper : Mapper<CategoryEntity, CategoryDomain> {
    override fun entityToDomain(entityModel: CategoryEntity): CategoryDomain {
        return CategoryDomain(
            id = entityModel.id,
            category = entityModel.category,
            description = entityModel.description,
            countOfActivities = entityModel.countOfActivities,
        )
    }

    override fun domainToEntity(domainModel: CategoryDomain): CategoryEntity {
        return CategoryEntity(
            id = domainModel.id,
            category = domainModel.category,
            description = domainModel.description,
            countOfActivities = domainModel.countOfActivities,
        )
    }
}