package me.vponomarenko.ticketsapp.domain.search

import me.vponomarenko.ticketsapp.domain.search.api.ICitiesRepository

class SearchForCityUseCase(private val citiesRepository: ICitiesRepository) {
    operator fun invoke(name: String) = citiesRepository.loadCities(name)
}