package me.vponomarenko.ticketsapp.data

import io.reactivex.Single
import me.vponomarenko.ticketsapp.data.entities.AirlineEntity
import me.vponomarenko.ticketsapp.data.entities.CityEntity
import me.vponomarenko.ticketsapp.data.entities.FlightEntity
import me.vponomarenko.ticketsapp.domain.search.entities.City
import java.util.Date
import kotlin.random.Random

internal class MockedDataSource : DataSource {
    override fun getCities(name: String): Single<List<CityEntity>> =
        Single.fromCallable {
            createListOfCities()
                .filter {
                    it.name.contains(name, true) || it.shortName.contains(name, true)
                }
        }

    override fun getFlights(from: City, to: City): Single<List<FlightEntity>> =
        Single.just(createFlights(from, to, Random.nextInt(15)))

    private fun createListOfCities() =
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
        )

    private fun createFlights(from: City, to: City, count: Int): List<FlightEntity> =
        mutableListOf<FlightEntity>().apply {
            val now = Date().time
            for (i in 0..count) {
                add(
                    FlightEntity(
                        Date(now - Random.nextInt(10000000)),
                        Date(now + Random.nextInt(10000000)),
                        CityEntity(from.name, from.shortName),
                        CityEntity(to.name, to.shortName),
                        (Random.nextFloat() * 400 + 100).toInt(),
                        AirlineEntity("S7", "")
                    )
                )
            }
        }

}