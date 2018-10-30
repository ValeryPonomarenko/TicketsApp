package me.vponomarenko.ticketsapp.domain.search.api

import me.vponomarenko.ticketsapp.domain.search.data.City

interface ICitiesRepository {
    fun loadCities(name: String): List<City>
}