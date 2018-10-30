package me.vponomarenko.ticketsapp.domain.search

import me.vponomarenko.ticketsapp.domain.search.api.ICitiesRepository
import me.vponomarenko.ticketsapp.domain.search.data.City

class SearchCityUseCase constructor(private val citiesRepository: ICitiesRepository) {
    operator fun invoke(name: String): List<City> = citiesRepository.loadCities(name)
}