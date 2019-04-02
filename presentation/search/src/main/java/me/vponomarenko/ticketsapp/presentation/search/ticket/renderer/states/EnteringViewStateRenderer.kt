package me.vponomarenko.ticketsapp.presentation.search.ticket.renderer.states

import android.view.View
import kotlinx.android.synthetic.main.fragment_search.view.*
import me.vponomarenko.tickets.app.common.renderer.ViewStateRenderer
import me.vponomarenko.ticketsapp.presentation.search.ticket.viewstate.SearchViewState

open class EnteringViewStateRenderer : ViewStateRenderer<SearchViewState> {
    override fun render(view: View, viewState: SearchViewState) {
        with(view) {
            motion.transitionToStart()
            text_destination_from.text = viewState.from?.name
            text_small_from.text = viewState.from?.shortName
            text_destination_to.text = viewState.to?.name
            text_small_to.text = viewState.to?.shortName
            progress.visibility = View.GONE
        }
    }
}