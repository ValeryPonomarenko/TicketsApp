package me.vponomarenko.ticketsapp.data.mappers

import me.vponomarenko.ticketsapp.data.entities.CityEntity
import me.vponomarenko.ticketsapp.domain.search.data.City

class CityEntityToCity {
    fun map(cityEntity: CityEntity): City =
        City(cityEntity.name, cityEntity.shortName)
}