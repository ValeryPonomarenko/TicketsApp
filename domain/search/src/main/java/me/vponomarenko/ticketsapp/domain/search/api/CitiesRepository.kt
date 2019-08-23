package me.vponomarenko.ticketsapp.domain.search.api

import io.reactivex.Single
import me.vponomarenko.ticketsapp.domain.search.data.City

interface CitiesRepository {
    fun loadCities(name: String): Single<List<City>>
}