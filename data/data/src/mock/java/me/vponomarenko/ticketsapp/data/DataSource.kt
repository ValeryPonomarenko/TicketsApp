package me.vponomarenko.ticketsapp.data

import me.vponomarenko.ticketsapp.data.entities.AirlineEntity
import me.vponomarenko.ticketsapp.data.entities.CityEntity
import me.vponomarenko.ticketsapp.data.entities.FlightEntity
import me.vponomarenko.ticketsapp.domain.search.data.City
import java.util.Date

class DataSource : IDataSource {
    override fun getCities(name: String) =
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

    override fun getFlights(from: City, to: City) =
        listOf(
            FlightEntity(
                Date(),
                Date(),
                CityEntity(from.name, from.shortName),
                CityEntity(to.name, to.shortName),
                600,
                AirlineEntity("S7", "")
            ),
            FlightEntity(
                Date(),
                Date(),
                CityEntity(from.name, from.shortName),
                CityEntity(to.name, to.shortName),
                600,
                AirlineEntity("S7", "")
            ),
            FlightEntity(
                Date(),
                Date(),
                CityEntity(from.name, from.shortName),
                CityEntity(to.name, to.shortName),
                600,
                AirlineEntity("S7", "")
            ),
            FlightEntity(
                Date(),
                Date(),
                CityEntity(from.name, from.shortName),
                CityEntity(to.name, to.shortName),
                600,
                AirlineEntity("S7", "")
            )
        )
}