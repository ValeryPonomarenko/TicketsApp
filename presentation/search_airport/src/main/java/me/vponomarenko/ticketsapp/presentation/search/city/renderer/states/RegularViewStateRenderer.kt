package me.vponomarenko.ticketsapp.presentation.search.city.renderer.states

import android.view.View
import kotlinx.android.synthetic.main.fragment_destination.view.*
import me.vponomarenko.tickets.app.common.renderer.ViewStateRenderer
import me.vponomarenko.ticketsapp.presentation.search.city.recycler.DestinationsAdapter
import me.vponomarenko.ticketsapp.presentation.search.city.viewstate.DestinationViewState
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 01/04/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class RegularViewStateRenderer @Inject constructor(
    private val adapter: DestinationsAdapter
) : ViewStateRenderer<DestinationViewState> {
    override fun render(view: View, viewState: DestinationViewState) {
        view.progress.visibility = View.GONE
        view.text_message.visibility = View.GONE
        view.recyclerView_destinations.visibility = View.VISIBLE
        adapter.update(viewState.destinations)
    }
}