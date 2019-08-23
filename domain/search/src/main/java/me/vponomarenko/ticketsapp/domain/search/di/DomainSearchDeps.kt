package me.vponomarenko.ticketsapp.domain.search.di

import me.vponomarenko.ticketsapp.domain.search.api.CitiesRepository
import me.vponomarenko.ticketsapp.domain.search.api.FlightsRepository

interface DomainSearchDeps {
    fun provideCitiesRepository(): CitiesRepository
    fun provideFlightsRepository(): FlightsRepository
}