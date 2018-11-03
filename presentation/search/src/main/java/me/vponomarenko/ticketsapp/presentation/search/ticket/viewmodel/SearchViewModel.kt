package me.vponomarenko.ticketsapp.presentation.search.ticket.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.vponomarenko.ticketsapp.presentation.search.ticket.navigation.SearchNavigation
import me.vponomarenko.ticketsapp.presentation.search.ticket.viewstate.SearchViewState
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 03/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class SearchViewModel @Inject constructor(
    private val navigation: SearchNavigation
) : ViewModel() {

    private val _viewState = MutableLiveData<SearchViewState>()

    val viewState: LiveData<SearchViewState>
        get() = _viewState

    fun onDepartingFromClick() {
        navigation.openDestinationSearch(true)
    }

    fun onFlightToClick() {
        navigation.openDestinationSearch(false)
    }
}