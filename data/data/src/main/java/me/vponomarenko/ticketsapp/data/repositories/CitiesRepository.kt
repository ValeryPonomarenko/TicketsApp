package me.vponomarenko.ticketsapp.data.repositories

import me.vponomarenko.ticketsapp.data.IDataSource
import me.vponomarenko.ticketsapp.data.mappers.CityEntityToCity
import me.vponomarenko.ticketsapp.domain.search.api.ICitiesRepository
import me.vponomarenko.ticketsapp.domain.search.data.City
import javax.inject.Inject

class CitiesRepository @Inject constructor(
    private val dataSource: IDataSource,
    private val mapper: CityEntityToCity
): ICitiesRepository {
    override fun loadCities(name: String): List<City> =
        dataSource.getCities(name).map(mapper::map)
}