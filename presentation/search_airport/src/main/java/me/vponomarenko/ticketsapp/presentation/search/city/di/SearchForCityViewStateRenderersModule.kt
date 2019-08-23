package me.vponomarenko.ticketsapp.presentation.search.city.di

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import me.vponomarenko.tickets.app.common.ext.toPair
import me.vponomarenko.tickets.app.common.renderer.Renderer
import me.vponomarenko.tickets.app.common.renderer.ViewStateRenderer
import me.vponomarenko.ticketsapp.presentation.search.city.renderer.DestinationViewStateRendererPicker
import me.vponomarenko.ticketsapp.presentation.search.city.renderer.states.EmptyQueryViewStateRenderer
import me.vponomarenko.ticketsapp.presentation.search.city.renderer.states.EmptyViewStateRenderer
import me.vponomarenko.ticketsapp.presentation.search.city.renderer.states.LoadingViewStateRenderer
import me.vponomarenko.ticketsapp.presentation.search.city.renderer.states.RegularViewStateRenderer
import me.vponomarenko.ticketsapp.presentation.search.city.viewstate.DestinationViewState
import javax.inject.Singleton
import kotlin.reflect.KClass

/**
 * Author: Valery Ponomarenko
 * Date: 01/04/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

private typealias DestinationViewStateRendererPair =
    Pair<KClass<out ViewStateRenderer<DestinationViewState>>, ViewStateRenderer<DestinationViewState>>

@Module
internal class SearchForCityViewStateRenderersModule {

    @Singleton
    @Provides
    @IntoSet
    fun provideEmptyQueryViewStateRenderer(renderer: EmptyQueryViewStateRenderer) = renderer.toPair()

    @Singleton
    @Provides
    @IntoSet
    fun provideEmptyViewStateRenderer(renderer: EmptyViewStateRenderer) = renderer.toPair()

    @Singleton
    @Provides
    @IntoSet
    fun provideLoadingViewStateRenderer(renderer: LoadingViewStateRenderer) = renderer.toPair()

    @Singleton
    @Provides
    @IntoSet
    fun provideRegularViewStateRenderer(renderer: RegularViewStateRenderer) = renderer.toPair()

    @Singleton
    @Provides
    fun provideRenderer(
        renderers: @JvmSuppressWildcards Set<DestinationViewStateRendererPair>
    ): Renderer<DestinationViewState> = Renderer(DestinationViewStateRendererPicker(), renderers.toMap())
}