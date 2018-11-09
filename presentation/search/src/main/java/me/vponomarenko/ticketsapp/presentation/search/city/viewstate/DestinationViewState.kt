package me.vponomarenko.ticketsapp.presentation.search.city.viewstate

import me.vponomarenko.ticketsapp.presentation.search.city.recycler.SpannableCity

/**
 * Author: Valery Ponomarenko
 * Date: 08/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

sealed class DestinationViewState {
    object Loading : DestinationViewState()
    data class Loaded(val destinations: List<SpannableCity>) : DestinationViewState()
}