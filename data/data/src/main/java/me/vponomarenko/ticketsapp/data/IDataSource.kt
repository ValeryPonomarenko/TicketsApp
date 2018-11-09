package me.vponomarenko.ticketsapp.data

import me.vponomarenko.ticketsapp.data.entities.CityEntity
import me.vponomarenko.ticketsapp.data.entities.FlightEntity
import me.vponomarenko.ticketsapp.domain.search.data.City

interface IDataSource {
    fun getCities(name: String): List<CityEntity>
    fun getFlights(from: City, to: City): List<FlightEntity>
}