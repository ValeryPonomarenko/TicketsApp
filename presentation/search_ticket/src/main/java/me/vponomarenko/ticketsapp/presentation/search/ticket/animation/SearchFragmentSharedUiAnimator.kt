package me.vponomarenko.ticketsapp.presentation.search.ticket.animation

import android.view.View
import me.vponomarenko.tickets.app.common.SharedUiElementsAnimator

/**
 * Author: Valery Ponomarenko
 * Date: 06/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

interface SearchFragmentSharedUiAnimator : SharedUiElementsAnimator {
    fun prepareFrom(view: View)
    fun prepareTo(view: View)
}