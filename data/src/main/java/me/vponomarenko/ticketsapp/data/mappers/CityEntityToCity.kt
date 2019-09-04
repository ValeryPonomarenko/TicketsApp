package me.vponomarenko.ticketsapp.data.mappers

import me.vponomarenko.ticketsapp.data.entities.CityEntity
import me.vponomarenko.ticketsapp.domain.search.entities.City

internal class CityEntityToCity {
    fun map(cityEntity: CityEntity) =
        City(cityEntity.name, cityEntity.shortName)
}