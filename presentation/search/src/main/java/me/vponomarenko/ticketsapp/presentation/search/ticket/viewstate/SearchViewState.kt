package me.vponomarenko.ticketsapp.presentation.search.ticket.viewstate

import me.vponomarenko.ticketsapp.domain.search.data.City

/**
 * Author: Valery Ponomarenko
 * Date: 03/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

sealed class SearchViewState {
    data class Entering(val from: City, val to: City) : SearchViewState()
}