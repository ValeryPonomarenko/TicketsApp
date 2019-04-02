package me.vponomarenko.ticketsapp.domain.search.api

import io.reactivex.Single
import me.vponomarenko.ticketsapp.domain.search.data.City
import me.vponomarenko.ticketsapp.domain.search.data.Flight

/**
 * Author: Valery Ponomarenko
 * Date: 10/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

interface IFlightsRepository {
    fun loadFlights(from: City, to: City): Single<List<Flight>>
}