package me.vponomarenko.ticketsapp.presentation.search.ticket.renderer.states

import android.view.View
import kotlinx.android.synthetic.main.fragment_search.view.*
import me.vponomarenko.tickets.app.common.renderer.ViewStateRenderer
import me.vponomarenko.ticketsapp.presentation.search.ticket.recycler.FlightsAdapter
import me.vponomarenko.ticketsapp.presentation.search.ticket.viewstate.SearchViewState

class LoadingViewStateRenderer(private val flightsAdapter: FlightsAdapter) : ViewStateRenderer<SearchViewState> {
    override fun render(view: View, viewState: SearchViewState) {
        flightsAdapter.flights = emptyList()
        flightsAdapter.notifyDataSetChanged()
        view.progress.visibility = View.VISIBLE
        view.motion.transitionToEnd()
    }
}