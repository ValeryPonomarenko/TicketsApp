package me.vponomarenko.ticketsapp.presentation.search.ticket.renderer.states

import android.view.View
import android.widget.Toast
import me.vponomarenko.tickets.app.common.renderer.ViewStateRenderer
import me.vponomarenko.ticketsapp.presentation.search.ticket.viewstate.SearchViewState

/**
 * Author: Valery Ponomarenko
 * Date: 2019-04-17
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

internal class EmptyResultStateRenderer(
    private val loadedViewStateRenderer: LoadedViewStateRenderer
) : ViewStateRenderer<SearchViewState> {
    override fun render(view: View, viewState: SearchViewState) {
        loadedViewStateRenderer.render(view, viewState)
        Toast.makeText(
            view.context,
            "There are no tickets for you flight. Try again later.",
            Toast.LENGTH_SHORT
        ).show()
    }
}