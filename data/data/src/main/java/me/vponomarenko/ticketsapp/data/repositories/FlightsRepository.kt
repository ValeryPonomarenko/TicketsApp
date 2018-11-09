package me.vponomarenko.ticketsapp.data.repositories

import me.vponomarenko.ticketsapp.data.IDataSource
import me.vponomarenko.ticketsapp.data.mappers.FlightEntityToFlight
import me.vponomarenko.ticketsapp.domain.search.api.IFlightsRepository
import me.vponomarenko.ticketsapp.domain.search.data.City

/**
 * Author: Valery Ponomarenko
 * Date: 10/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class FlightsRepository(
    private val dataSource: IDataSource,
    private val flightEntityToFlight: FlightEntityToFlight
) : IFlightsRepository {
    override fun loadFlights(from: City, to: City) =
        dataSource.getFlights(from, to).map(flightEntityToFlight::map)
}