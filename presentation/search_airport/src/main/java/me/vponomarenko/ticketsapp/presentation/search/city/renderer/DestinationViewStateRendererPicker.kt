package me.vponomarenko.ticketsapp.presentation.search.city.renderer

import me.vponomarenko.tickets.app.common.renderer.ViewStateRenderer
import me.vponomarenko.tickets.app.common.renderer.ViewStateRendererPicker
import me.vponomarenko.ticketsapp.presentation.search.city.renderer.states.EmptyQueryViewStateRenderer
import me.vponomarenko.ticketsapp.presentation.search.city.renderer.states.EmptyViewStateRenderer
import me.vponomarenko.ticketsapp.presentation.search.city.renderer.states.LoadingViewStateRenderer
import me.vponomarenko.ticketsapp.presentation.search.city.renderer.states.RegularViewStateRenderer
import me.vponomarenko.ticketsapp.presentation.search.city.viewstate.DestinationViewState
import kotlin.reflect.KClass

/**
 * Author: Valery Ponomarenko
 * Date: 01/04/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

internal class DestinationViewStateRendererPicker : ViewStateRendererPicker<DestinationViewState> {
    override fun pick(viewState: DestinationViewState): KClass<out ViewStateRenderer<DestinationViewState>> =
        when {
            viewState.query.isBlank() -> EmptyQueryViewStateRenderer::class
            viewState.isLoading -> LoadingViewStateRenderer::class
            viewState.destinations.isEmpty() -> EmptyViewStateRenderer::class
            else -> RegularViewStateRenderer::class
        }
}