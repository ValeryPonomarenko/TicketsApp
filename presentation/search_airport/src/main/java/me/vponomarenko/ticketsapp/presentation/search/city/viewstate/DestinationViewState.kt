package me.vponomarenko.ticketsapp.presentation.search.city.viewstate

import me.vponomarenko.ticketsapp.presentation.search.city.recycler.SpannableCity

/**
 * Author: Valery Ponomarenko
 * Date: 01/04/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

data class DestinationViewState(
    val destinations: List<SpannableCity> = listOf(),
    val query: String = "",
    val isLoading: Boolean = false
)