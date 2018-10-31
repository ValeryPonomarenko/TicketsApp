package me.vponomarenko.ticketsapp.domain.search.di.deps

import me.vponomarenko.ticketsapp.domain.search.api.ICitiesRepository

interface DomainSearchForCitiesDepsIn {
    fun provideCitiesRepository(): ICitiesRepository
}