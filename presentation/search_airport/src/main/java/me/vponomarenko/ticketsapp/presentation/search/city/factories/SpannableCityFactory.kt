package me.vponomarenko.ticketsapp.presentation.search.city.factories

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import me.vponomarenko.ticketsapp.domain.search.data.City
import me.vponomarenko.ticketsapp.presentation.search.city.recycler.SpannableCity
import javax.inject.Inject

internal class SpannableCityFactory @Inject constructor() {

    companion object {
        private const val NO_MATCH = -1
    }

    fun getSpannableCity(city: City, searchWord: String) =
        SpannableCity(
            city,
            SpannableString("${city.name} (${city.shortName})").apply {
                indexOf(searchWord, ignoreCase = true).takeIf { it != NO_MATCH }?.let {
                    setSpan(
                        StyleSpan(Typeface.BOLD),
                        it,
                        it + searchWord.length,
                        Spannable.SPAN_EXCLUSIVE_INCLUSIVE
                    )
                }
            }
        )
}