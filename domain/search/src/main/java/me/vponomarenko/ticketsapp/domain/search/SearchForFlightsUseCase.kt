package me.vponomarenko.ticketsapp.domain.search

import io.reactivex.Scheduler
import io.reactivex.Single
import me.vponomarenko.ticketsapp.domain.common.di.IoScheduler
import me.vponomarenko.ticketsapp.domain.common.di.UiScheduler
import me.vponomarenko.ticketsapp.domain.search.api.FlightsRepository
import me.vponomarenko.ticketsapp.domain.search.data.City
import me.vponomarenko.ticketsapp.domain.search.data.Flight
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 10/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Singleton
class SearchForFlightsUseCase @Inject constructor(
    private val flightRepository: FlightsRepository,
    @IoScheduler private val ioScheduler: Scheduler,
    @UiScheduler private val uiScheduler: Scheduler
) {
    operator fun invoke(from: City, to: City): Single<List<Flight>> =
        flightRepository
            .loadFlights(from, to)
            .subscribeOn(ioScheduler)
            .observeOn(uiScheduler)
}