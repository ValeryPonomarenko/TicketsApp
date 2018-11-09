package me.vponomarenko.ticketsapp.presentation.search.ticket.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.vponomarenko.ticketsapp.domain.search.SearchForFlightsUseCase
import me.vponomarenko.ticketsapp.domain.search.data.City
import me.vponomarenko.ticketsapp.presentation.search.ticket.navigation.SearchNavigation
import me.vponomarenko.ticketsapp.presentation.search.ticket.viewstate.SearchViewState
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 03/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class SearchViewModel @Inject constructor(
    private val searchForFlightsUseCase: SearchForFlightsUseCase,
    private val navigation: SearchNavigation
) : ViewModel() {

    private val _viewState = MutableLiveData<SearchViewState>()

    val viewState: LiveData<SearchViewState>
        get() = _viewState

    private var destinations: Pair<City?, City?> = Pair(null, null)

    init {
        setDestinations()
    }

    fun onDepartingFromClick() {
        navigation.openDestinationSearch(true) {
            destinations = Pair(it, destinations.second)
            setDestinations(it, (_viewState.value as? SearchViewState.Entering)?.to)
        }
    }

    fun onFlightToClick() {
        navigation.openDestinationSearch(false) {
            destinations = Pair(destinations.first, it)
            setDestinations((_viewState.value as? SearchViewState.Entering)?.from, it)
        }
    }

    fun search() {
        val (from, to) = destinations
        if (from != null && to != null) {
            _viewState.value = SearchViewState.Loaded(searchForFlightsUseCase(from, to))
        }
    }

    private fun setDestinations(from: City? = null, to: City? = null) {
        _viewState.value = SearchViewState.Entering(
            from ?: City("", ""),
            to ?: City("", "")
        )
    }
}