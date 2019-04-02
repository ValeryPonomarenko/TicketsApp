package me.vponomarenko.ticketsapp.presentation.search.ticket.renderer.states

import android.view.View
import kotlinx.android.synthetic.main.fragment_search.view.*
import me.vponomarenko.tickets.app.common.renderer.ViewStateRenderer
import me.vponomarenko.ticketsapp.presentation.search.ticket.recycler.FlightsAdapter
import me.vponomarenko.ticketsapp.presentation.search.ticket.viewstate.SearchViewState

class LoadedViewStateRenderer(private val adapter: FlightsAdapter) : ViewStateRenderer<SearchViewState> {
	override fun render(view: View, viewState: SearchViewState) {
		view.motion.transitionToEnd()
		adapter.flights = viewState.flights
		adapter.notifyDataSetChanged()
	}

}