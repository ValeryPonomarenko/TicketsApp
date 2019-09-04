package me.vponomarenko.ticketsapp.data.repositories

import io.reactivex.Single
import me.vponomarenko.ticketsapp.data.DataSource
import me.vponomarenko.ticketsapp.data.mappers.FlightEntityToFlight
import me.vponomarenko.ticketsapp.domain.search.repositories.FlightsRepository
import me.vponomarenko.ticketsapp.domain.search.entities.City
import me.vponomarenko.ticketsapp.domain.search.entities.Flight
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 10/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

internal class FlightsRepositoryImpl @Inject constructor(
    private val dataSource: DataSource,
    private val mapper: FlightEntityToFlight
) : FlightsRepository {
    override fun loadFlights(from: City, to: City): Single<List<Flight>> =
        dataSource.getFlights(from, to)
            .map { it.map(mapper::map) }
            .delay(3, TimeUnit.SECONDS)
}