package me.vponomarenko.ticketsapp.presentation.search.city.renderer.states

import android.view.View
import kotlinx.android.synthetic.main.fragment_destination.view.*
import me.vponomarenko.tickets.app.common.renderer.ViewStateRenderer
import me.vponomarenko.ticketsapp.presentation.search.R
import me.vponomarenko.ticketsapp.presentation.search.city.viewstate.DestinationViewState

/**
 * Author: Valery Ponomarenko
 * Date: 01/04/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class EmptyQueryViewStateRenderer : ViewStateRenderer<DestinationViewState> {
    override fun render(view: View, viewState: DestinationViewState) {
        view.text_message.visibility = View.VISIBLE
        view.progress.visibility = View.GONE
        view.recyclerView_destinations.visibility = View.GONE
        view.text_message.setText(R.string.empty_query_message)
    }
}