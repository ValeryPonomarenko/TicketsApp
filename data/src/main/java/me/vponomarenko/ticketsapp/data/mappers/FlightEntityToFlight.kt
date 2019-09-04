package me.vponomarenko.ticketsapp.data.mappers

import me.vponomarenko.ticketsapp.data.entities.FlightEntity
import me.vponomarenko.ticketsapp.domain.search.entities.Flight

internal class FlightEntityToFlight(
    private val cityEntityToCity: CityEntityToCity,
    private val airlineEntityToAirline: AirlineEntityToAirline
) {
    fun map(flightEntity: FlightEntity) =
        Flight(
            flightEntity.dateFrom,
            flightEntity.dateTo,
            cityEntityToCity.map(flightEntity.from),
            cityEntityToCity.map(flightEntity.to),
            flightEntity.cost,
            airlineEntityToAirline.map(flightEntity.airline)
        )
}