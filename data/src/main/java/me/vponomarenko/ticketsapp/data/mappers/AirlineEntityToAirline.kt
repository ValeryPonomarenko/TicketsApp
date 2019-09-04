package me.vponomarenko.ticketsapp.data.mappers

import me.vponomarenko.ticketsapp.data.entities.AirlineEntity
import me.vponomarenko.ticketsapp.domain.search.entities.Airline

internal class AirlineEntityToAirline {
    fun map(airlineEntity: AirlineEntity) =
        Airline(airlineEntity.name, airlineEntity.imageUrl)
}