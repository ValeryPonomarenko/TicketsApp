package me.vponomarenko.ticketsapp.presentation.search.city.viewmodel

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.vponomarenko.ticketsapp.domain.search.SearchForCityUseCase
import me.vponomarenko.ticketsapp.domain.search.data.City
import me.vponomarenko.ticketsapp.presentation.search.city.navigation.DestinationNavigation
import me.vponomarenko.ticketsapp.presentation.search.city.recycler.SpannableCity
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

    companion object {
        private const val NO_MATCH = -1
    }

    private val _viewState = MutableLiveData<DestinationViewState>()

    val viewState: LiveData<DestinationViewState>
        get() = _viewState

    fun search(cityName: String) {
        _viewState.value = DestinationViewState.Loaded(
            searchForCityUseCase(cityName).map { mapToSpannableCity(it, cityName) }
        )
    }

    private fun mapToSpannableCity(city: City, searchWord: String) =
        SpannableCity(
            SpannableString(city.name).apply {
                indexOf(searchWord, ignoreCase = true).takeIf { it != NO_MATCH }?.let {
                    setSpan(StyleSpan(Typeface.BOLD), it, it + searchWord.length, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
                }
            }
        )
}