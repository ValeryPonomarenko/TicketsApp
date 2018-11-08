package me.vponomarenko.ticketsapp.data

import me.vponomarenko.ticketsapp.data.entities.CityEntity

class DataSource : IDataSource {
    override fun getCities(name: String): List<CityEntity> =
        listOf(
            CityEntity("Moscow", "DME"),
            CityEntity("Sochi", "AER"),
            CityEntity("Detroit", "DET"),
            CityEntity("Novosibirsk", "NSK"),
            CityEntity("Kemerovo", "KEJ"),
            CityEntity("Los Angeles", "LAX"),
            CityEntity("London", "LHR"),
            CityEntity("Rome", "FCO"),
            CityEntity("Vancouver", "CXH"),
            CityEntity("Milan", "BGY"),
            CityEntity("Atlanta", "ATL")
        ).filter { it.name.contains(name, true) || it.shortName.contains(name, true) }
}