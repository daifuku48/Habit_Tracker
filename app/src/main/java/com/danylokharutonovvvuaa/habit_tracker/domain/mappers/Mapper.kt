package com.danylokharutonovvvuaa.habit_tracker.domain.mappers

interface Mapper<EntityModel, DomainModel> {
    fun entityToDomain(entityModel: EntityModel) : DomainModel

    fun domainToEntity(domainModel: DomainModel) : EntityModel
}