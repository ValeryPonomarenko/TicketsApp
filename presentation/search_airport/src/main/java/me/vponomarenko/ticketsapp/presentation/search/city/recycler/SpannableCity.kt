package me.vponomarenko.ticketsapp.presentation.search.city.recycler

import android.text.SpannableString
import me.vponomarenko.ticketsapp.domain.search.data.City

internal data class SpannableCity(val city: City, val spannable: SpannableString)