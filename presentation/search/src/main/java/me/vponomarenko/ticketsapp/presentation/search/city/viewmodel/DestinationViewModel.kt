package me.vponomarenko.ticketsapp.presentation.search.city.viewmodel

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.Disposable
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

    val viewState: LiveData<DestinationViewState>
        get() = _viewState

    private var disposable: Disposable? = null

    private val _viewState = MutableLiveData<DestinationViewState>()

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }

    fun search(cityName: String) {
        disposable?.dispose()
        disposable = searchForCityUseCase(cityName)
            .map { it.map { city -> mapToSpannableCity(city, cityName) } }
            .subscribe { cities: List<SpannableCity> ->
                _viewState.value = DestinationViewState.Loaded(cities)
            }
    }

    fun onDestinationSelected(city: SpannableCity) {
        navigation.exitWithResult(city.city)
    }

    fun back() {
        navigation.exit()
    }

    private fun mapToSpannableCity(city: City, searchWord: String) =
        SpannableCity(
            city,
            SpannableString("${city.name} (${city.shortName})").apply {
                indexOf(searchWord, ignoreCase = true).takeIf { it != NO_MATCH }?.let {
                    setSpan(StyleSpan(Typeface.BOLD), it, it + searchWord.length, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
                }
            }
        )
}