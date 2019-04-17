package me.vponomarenko.ticketsapp.presentation.search.city.viewmodel

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import me.vponomarenko.ticketsapp.domain.search.SearchForCityUseCase
import me.vponomarenko.ticketsapp.domain.search.data.City
import me.vponomarenko.ticketsapp.presentation.search.city.navigation.DestinationNavigation
import me.vponomarenko.ticketsapp.presentation.search.city.recycler.SpannableCity
import me.vponomarenko.ticketsapp.presentation.search.city.viewstate.DestinationViewState
import java.util.concurrent.TimeUnit
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
        private const val DEBOUNCE_TIMEOUT = 300L
    }

    val viewState: LiveData<DestinationViewState>
        get() = _viewState

    private val _viewState = MutableLiveData<DestinationViewState>()

    private lateinit var destinationViewState: DestinationViewState

    private var disposable: Disposable? = null

    init {
        updateViewState(DestinationViewState())
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }

    fun observeSearchChanges(observable: Observable<String>) {
        disposable?.dispose()
        disposable =
            observable
                .debounce(DEBOUNCE_TIMEOUT, TimeUnit.MILLISECONDS)
                .doOnNext { updateViewState(destinationViewState.copy(query = it, isLoading = true)) }
                .flatMap { cityName ->
                    searchForCityUseCase(cityName).toObservable().map { cityName to it }
                }
                .map { (cityName, cities) -> cities.map { city -> mapToSpannableCity(city, cityName) } }
                .subscribe {
                    if (destinationViewState.query.isNotBlank()) {
                        updateViewState(destinationViewState.copy(destinations = it, isLoading = false))
                    }
                }
    }

    fun onDestinationSelected(city: SpannableCity) {
        navigation.exitWithResult(city.city)
    }

    fun back() {
        navigation.exit()
    }

    private fun updateViewState(viewState: DestinationViewState) {
        destinationViewState = viewState
        _viewState.postValue(viewState)
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