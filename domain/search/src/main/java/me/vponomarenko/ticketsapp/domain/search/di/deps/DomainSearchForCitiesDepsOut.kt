package me.vponomarenko.ticketsapp.domain.search.di.deps

import me.vponomarenko.ticketsapp.domain.search.SearchForCityUseCase

interface DomainSearchForCitiesDepsOut {
    fun provideSearchCityUseCase(): SearchForCityUseCase
}