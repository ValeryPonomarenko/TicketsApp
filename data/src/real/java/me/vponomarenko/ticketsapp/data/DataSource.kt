package me.vponomarenko.ticketsapp.data

import me.vponomarenko.ticketsapp.data.entities.CityEntity
import me.vponomarenko.ticketsapp.data.entities.FlightEntity
import me.vponomarenko.ticketsapp.domain.search.data.City

class DataSource : IDataSource {
    override fun getCities(name: String): List<CityEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFlights(from: City, to: City): List<FlightEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}