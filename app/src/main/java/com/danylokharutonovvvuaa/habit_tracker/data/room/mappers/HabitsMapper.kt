package com.danylokharutonovvvuaa.habit_tracker.data.room.mappers

import com.danylokharutonovvvuaa.habit_tracker.data.room.entities.HabitEntity
import com.danylokharutonovvvuaa.habit_tracker.domain.mappers.Mapper
import com.danylokharutonovvvuaa.habit_tracker.domain.model.HabitDomain

class HabitsMapper : Mapper<HabitEntity, HabitDomain> {
    override fun entityToDomain(entityModel: HabitEntity): HabitDomain {
        return HabitDomain(
            id = entityModel.id,
            categoryId = entityModel.categoryId,
            description = entityModel.description,
            isFinishedToday = entityModel.isFinishedToday
        )
    }

    override fun domainToEntity(domainModel: HabitDomain): HabitEntity {
        return HabitEntity(
            id = domainModel.id,
            categoryId = domainModel.categoryId,
            description = domainModel.description,
            isFinishedToday = domainModel.isFinishedToday
        )
    }

}