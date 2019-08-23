package me.vponomarenko.ticketsapp.presentation.search.ticket.renderer.states

import android.view.View
import kotlinx.android.synthetic.main.fragment_search.view.*
import me.vponomarenko.tickets.app.common.renderer.ViewStateRenderer
import me.vponomarenko.ticketsapp.presentation.search.ticket.recycler.FlightsAdapter
import me.vponomarenko.ticketsapp.presentation.search.ticket.viewstate.SearchViewState

internal class LoadedViewStateRenderer(
    private val adapter: FlightsAdapter
) : ViewStateRenderer<SearchViewState> {
    override fun render(view: View, viewState: SearchViewState) {
        view.progress.visibility = View.GONE
        adapter.flights = viewState.flights
        adapter.notifyDataSetChanged()
        view.motion.transitionToEnd()
    }
}