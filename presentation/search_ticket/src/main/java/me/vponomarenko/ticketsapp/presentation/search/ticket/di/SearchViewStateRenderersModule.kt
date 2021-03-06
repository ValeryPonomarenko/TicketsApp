package me.vponomarenko.ticketsapp.presentation.search.ticket.di

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import me.vponomarenko.tickets.app.common.renderer.Renderer
import me.vponomarenko.tickets.app.common.renderer.ViewStateRenderer
import me.vponomarenko.ticketsapp.presentation.search.ticket.recycler.FlightsAdapter
import me.vponomarenko.ticketsapp.presentation.search.ticket.renderer.SearchViewStateRendererPicker
import me.vponomarenko.ticketsapp.presentation.search.ticket.renderer.states.EmptyResultStateRenderer
import me.vponomarenko.ticketsapp.presentation.search.ticket.renderer.states.EnteringViewStateRenderer
import me.vponomarenko.ticketsapp.presentation.search.ticket.renderer.states.ErrorWhileEnteringViewStateRenderer
import me.vponomarenko.ticketsapp.presentation.search.ticket.renderer.states.LoadedViewStateRenderer
import me.vponomarenko.ticketsapp.presentation.search.ticket.renderer.states.LoadingViewStateRenderer
import me.vponomarenko.ticketsapp.presentation.search.ticket.viewstate.SearchViewState
import javax.inject.Singleton
import kotlin.reflect.KClass

private typealias SearchViewStateRendererPair =
    Pair<KClass<out ViewStateRenderer<SearchViewState>>, ViewStateRenderer<SearchViewState>>

@Module
internal class SearchViewStateRenderersModule {

    @Singleton
    @Provides
    @IntoSet
    fun provideEnteringViewStateRenderer(): SearchViewStateRendererPair =
        EnteringViewStateRenderer::class to EnteringViewStateRenderer()

    @Singleton
    @Provides
    @IntoSet
    fun provideErrorWhileEnteringViewStateRenderer(): SearchViewStateRendererPair =
        ErrorWhileEnteringViewStateRenderer::class to ErrorWhileEnteringViewStateRenderer()

    @Singleton
    @Provides
    @IntoSet
    fun provideLoadingViewStateRenderer(adapter: FlightsAdapter): SearchViewStateRendererPair =
        LoadingViewStateRenderer::class to LoadingViewStateRenderer(adapter)

    @Singleton
    @Provides
    @IntoSet
    fun provideLoadedViewStateRenderer(adapter: FlightsAdapter): SearchViewStateRendererPair =
        LoadedViewStateRenderer::class to LoadedViewStateRenderer(adapter)

    @Singleton
    @Provides
    @IntoSet
    fun provideEmptyResultViewStateRenderer(adapter: FlightsAdapter): SearchViewStateRendererPair =
        EmptyResultStateRenderer::class to EmptyResultStateRenderer(LoadedViewStateRenderer(adapter))

    @Singleton
    @Provides
    fun provideRenderer(
        renderers: @JvmSuppressWildcards Set<SearchViewStateRendererPair>
    ): Renderer<SearchViewState> = Renderer(SearchViewStateRendererPicker(), renderers.toMap())
}