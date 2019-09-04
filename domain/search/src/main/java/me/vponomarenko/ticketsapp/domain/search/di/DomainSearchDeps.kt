package me.vponomarenko.ticketsapp.domain.search.di

import me.vponomarenko.ticketsapp.domain.search.repositories.CitiesRepository
import me.vponomarenko.ticketsapp.domain.search.repositories.FlightsRepository

interface DomainSearchDeps {
    fun provideCitiesRepository(): CitiesRepository
    fun provideFlightsRepository(): FlightsRepository
}