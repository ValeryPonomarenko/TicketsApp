package me.vponomarenko.ticketsapp.data

import me.vponomarenko.ticketsapp.data.entities.CityEntity

class DataSource : IDataSource {
    override fun getCities(name: String): List<CityEntity> =
        listOf(
            CityEntity("Moscow", "MSK"),
            CityEntity("New York City", "NYC")
        )
}