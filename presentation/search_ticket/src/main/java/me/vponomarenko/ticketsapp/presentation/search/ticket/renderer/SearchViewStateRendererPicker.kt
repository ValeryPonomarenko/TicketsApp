package me.vponomarenko.ticketsapp.presentation.search.ticket.renderer

import me.vponomarenko.tickets.app.common.renderer.ViewStateRenderer
import me.vponomarenko.tickets.app.common.renderer.ViewStateRendererPicker
import me.vponomarenko.ticketsapp.presentation.search.ticket.renderer.states.EmptyResultStateRenderer
import me.vponomarenko.ticketsapp.presentation.search.ticket.renderer.states.EnteringViewStateRenderer
import me.vponomarenko.ticketsapp.presentation.search.ticket.renderer.states.ErrorWhileEnteringViewStateRenderer
import me.vponomarenko.ticketsapp.presentation.search.ticket.renderer.states.LoadedViewStateRenderer
import me.vponomarenko.ticketsapp.presentation.search.ticket.renderer.states.LoadingViewStateRenderer
import me.vponomarenko.ticketsapp.presentation.search.ticket.viewstate.SearchViewState
import kotlin.reflect.KClass

class SearchViewStateRendererPicker : ViewStateRendererPicker<SearchViewState> {
    override fun pick(viewState: SearchViewState): KClass<out ViewStateRenderer<SearchViewState>> =
        when {
            viewState.isEntering -> EnteringViewStateRenderer::class
            !viewState.isEntering && (viewState.from == null || viewState.to == null) ->
                ErrorWhileEnteringViewStateRenderer::class
            viewState.isLoading -> LoadingViewStateRenderer::class
            viewState.flights.isEmpty() -> EmptyResultStateRenderer::class
            else -> LoadedViewStateRenderer::class
        }
}