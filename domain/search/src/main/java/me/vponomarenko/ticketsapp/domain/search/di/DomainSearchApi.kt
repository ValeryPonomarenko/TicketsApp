package me.vponomarenko.ticketsapp.domain.search.di

import me.vponomarenko.ticketsapp.domain.search.SearchForCityUseCase
import me.vponomarenko.ticketsapp.domain.search.SearchForFlightsUseCase

interface DomainSearchApi {
    fun provideSearchCityUseCase(): SearchForCityUseCase
    fun provideSearchFlightsUseCase(): SearchForFlightsUseCase
}