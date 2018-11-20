package me.vponomarenko.ticketsapp.data

import me.vponomarenko.ticketsapp.data.entities.AirlineEntity
import me.vponomarenko.ticketsapp.data.entities.CityEntity
import me.vponomarenko.ticketsapp.data.entities.FlightEntity
import me.vponomarenko.ticketsapp.domain.search.data.City
import java.util.Date
import java.util.Random

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
            .also { Thread.sleep(2000) }

    override fun getFlights(from: City, to: City): List<FlightEntity> {
        val random = Random()
        val count = random.nextInt(15)
        val now = Date().time
        return mutableListOf<FlightEntity>().apply {
            for (i in 0..count) {
                add(
                    FlightEntity(
                        Date(now - random.nextInt(10000000)),
                        Date(now + random.nextInt(10000000)),
                        CityEntity(from.name, from.shortName),
                        CityEntity(to.name, to.shortName),
                        (random.nextFloat() * 400 + 100).toInt(),
                        AirlineEntity("S7", "")
                    )
                )
            }
        }
    }
}