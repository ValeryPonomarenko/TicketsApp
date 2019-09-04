package me.vponomarenko.ticketsapp.presentation.search.ticket.navigation

import me.vponomarenko.ticketsapp.domain.search.entities.City

interface SearchNavigation {
    fun openDestinationSearch(isFrom: Boolean, resultListener: (City) -> Unit)
}