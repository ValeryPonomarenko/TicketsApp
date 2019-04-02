package me.vponomarenko.ticketsapp.presentation.search.ticket.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.vponomarenko.ticketsapp.domain.search.SearchForFlightsUseCase
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

    private lateinit var searchViewState: SearchViewState

    init {
        updateViewState(SearchViewState())
    }

    fun onDepartingFromClick() {
        updateViewState(searchViewState.copy(isEntering = true))
        navigation.openDestinationSearch(true) {
            updateViewState(searchViewState.copy(from = it))
        }
    }

    fun onFlightToClick() {
        updateViewState(searchViewState.copy(isEntering = true))
        navigation.openDestinationSearch(false) {
            updateViewState(searchViewState.copy(isEntering = true, to = it))
        }
    }

    fun search() {
        val (from, to) = Pair(searchViewState.from, searchViewState.to)
        if (from != null && to != null) {
            updateViewState(searchViewState.copy(isEntering = false, isLoading = true))
            updateViewState(searchViewState.copy(flights = searchForFlightsUseCase(from, to)))
        } else {
            updateViewState(searchViewState.copy(isEntering = false))
        }
    }

    fun changeSearch() {
        updateViewState(searchViewState.copy(isEntering = true))
    }

    private fun updateViewState(viewState: SearchViewState) {
        searchViewState = viewState
        _viewState.postValue(viewState)
    }
}