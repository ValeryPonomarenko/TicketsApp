package me.vponomarenko.ticketsapp.presentation.search.ticket.navigation

import me.vponomarenko.ticketsapp.domain.search.data.City

interface SearchNavigation {
    fun openDestinationSearch(isFrom: Boolean, resultListener: (City) -> Unit)
}