package me.vponomarenko.ticketsapp.presentation.search.city.renderer.states

import android.view.View
import kotlinx.android.synthetic.main.fragment_destination.view.*
import me.vponomarenko.tickets.app.common.renderer.ViewStateRenderer
import me.vponomarenko.ticketsapp.presentation.search.city.viewstate.DestinationViewState

/**
 * Author: Valery Ponomarenko
 * Date: 01/04/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class LoadingViewStateRenderer : ViewStateRenderer<DestinationViewState> {
    override fun render(view: View, viewState: DestinationViewState) {
        view.progress.visibility = View.VISIBLE
    }
}