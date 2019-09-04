package me.vponomarenko.ticketsapp.data

import io.reactivex.Single
import me.vponomarenko.ticketsapp.data.entities.CityEntity
import me.vponomarenko.ticketsapp.data.entities.FlightEntity
import me.vponomarenko.ticketsapp.domain.search.entities.City

internal interface DataSource {
    fun getCities(name: String): Single<List<CityEntity>>
    fun getFlights(from: City, to: City): Single<List<FlightEntity>>
}