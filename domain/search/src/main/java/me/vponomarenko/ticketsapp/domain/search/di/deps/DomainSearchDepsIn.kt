package me.vponomarenko.ticketsapp.domain.search.di.deps

import me.vponomarenko.ticketsapp.domain.search.api.ICitiesRepository
import me.vponomarenko.ticketsapp.domain.search.api.IFlightsRepository

interface DomainSearchDepsIn {
    fun provideCitiesRepository(): ICitiesRepository
    fun provideFlightsRepository(): IFlightsRepository
}