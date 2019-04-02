package me.vponomarenko.ticketsapp.data.repositories

import io.reactivex.Single
import me.vponomarenko.ticketsapp.data.IDataSource
import me.vponomarenko.ticketsapp.data.mappers.FlightEntityToFlight
import me.vponomarenko.ticketsapp.domain.search.api.IFlightsRepository
import me.vponomarenko.ticketsapp.domain.search.data.City
import me.vponomarenko.ticketsapp.domain.search.data.Flight
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 10/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class FlightsRepository @Inject constructor(
    private val dataSource: IDataSource,
    private val mapper: FlightEntityToFlight
) : IFlightsRepository {
    override fun loadFlights(from: City, to: City): Single<List<Flight>> =
        Single
            .just(dataSource.getFlights(from, to))
            .map { it.map(mapper::map) }
            .delay(3, TimeUnit.SECONDS)
}