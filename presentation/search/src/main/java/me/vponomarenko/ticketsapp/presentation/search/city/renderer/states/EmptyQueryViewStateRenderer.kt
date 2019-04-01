package me.vponomarenko.ticketsapp.presentation.search.city.renderer.states

import android.view.View
import kotlinx.android.synthetic.main.fragment_destination.view.*
import me.vponomarenko.tickets.app.common.renderer.ViewStateRenderer
import me.vponomarenko.ticketsapp.presentation.search.R
import me.vponomarenko.ticketsapp.presentation.search.city.recycler.DestinationsAdapter
import me.vponomarenko.ticketsapp.presentation.search.city.viewstate.DestinationViewState

/**
 * Author: Valery Ponomarenko
 * Date: 01/04/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class EmptyQueryViewStateRenderer(private val adapter: DestinationsAdapter) : ViewStateRenderer<DestinationViewState> {
    override fun render(view: View, viewState: DestinationViewState) {
        view.text_message.visibility = View.VISIBLE
        view.text_message.setText(R.string.empty_query_message)
        view.progress.visibility = View.GONE
        adapter.update(emptyList())
    }
}