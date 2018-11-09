package me.vponomarenko.ticketsapp.domain.search.di.deps

import me.vponomarenko.ticketsapp.domain.search.SearchForCityUseCase
import me.vponomarenko.ticketsapp.domain.search.SearchForFlightsUseCase

interface DomainSearchDepsOut {
    fun provideSearchCityUseCase(): SearchForCityUseCase
    fun provideSearchFlightsUseCase(): SearchForFlightsUseCase
}