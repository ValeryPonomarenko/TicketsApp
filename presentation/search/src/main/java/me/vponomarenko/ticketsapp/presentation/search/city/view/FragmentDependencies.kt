package me.vponomarenko.ticketsapp.presentation.search.city.view

import me.vponomarenko.ticketsapp.domain.search.SearchCityUseCase

interface FragmentDependencies {
    fun provideSearchCityUseCase(): SearchCityUseCase
}