package me.vponomarenko.ticketsapp.presentation.search.city.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.vponomarenko.ticketsapp.domain.search.SearchForCityUseCase
import me.vponomarenko.ticketsapp.presentation.search.city.navigation.DestinationNavigation
import me.vponomarenko.ticketsapp.presentation.search.city.viewstate.DestinationViewState
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 08/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class DestinationViewModel @Inject constructor(
    private val searchForCityUseCase: SearchForCityUseCase,
    private val navigation: DestinationNavigation
) : ViewModel() {

    private val _viewState = MutableLiveData<DestinationViewState>()

    val viewState: LiveData<DestinationViewState>
        get() = _viewState

    fun search(cityName: String) {
        _viewState.value = DestinationViewState.Loaded(searchForCityUseCase(cityName))
    }
}