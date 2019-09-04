package me.vponomarenko.ticketsapp.domain.search.repositories

import io.reactivex.Single
import me.vponomarenko.ticketsapp.domain.search.entities.City

interface CitiesRepository {
    fun loadCities(name: String): Single<List<City>>
}