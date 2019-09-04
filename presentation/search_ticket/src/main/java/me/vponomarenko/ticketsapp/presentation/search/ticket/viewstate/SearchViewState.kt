package me.vponomarenko.ticketsapp.presentation.search.ticket.viewstate

import me.vponomarenko.ticketsapp.domain.search.entities.City
import me.vponomarenko.ticketsapp.domain.search.entities.Flight

internal data class SearchViewState(
    val isEntering: Boolean = true,
    val from: City? = null,
    val to: City? = null,
    val isLoading: Boolean = false,
    val flights: List<Flight> = listOf()
)