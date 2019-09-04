package me.vponomarenko.ticketsapp.domain.search.repositories

import io.reactivex.Single
import me.vponomarenko.ticketsapp.domain.search.entities.City
import me.vponomarenko.ticketsapp.domain.search.entities.Flight

/**
 * Author: Valery Ponomarenko
 * Date: 10/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

interface FlightsRepository {
    fun loadFlights(from: City, to: City): Single<List<Flight>>
}