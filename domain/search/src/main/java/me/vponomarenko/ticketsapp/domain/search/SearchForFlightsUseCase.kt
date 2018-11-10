package me.vponomarenko.ticketsapp.domain.search

import me.vponomarenko.ticketsapp.domain.search.api.IFlightsRepository
import me.vponomarenko.ticketsapp.domain.search.data.City
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 10/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Singleton
class SearchForFlightsUseCase @Inject constructor(private val flightRepository: IFlightsRepository) {
    operator fun invoke(from: City, to: City) = flightRepository.loadFlights(from, to)
}