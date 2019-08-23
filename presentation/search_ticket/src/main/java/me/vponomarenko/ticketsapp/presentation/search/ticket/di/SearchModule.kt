package me.vponomarenko.ticketsapp.presentation.search.ticket.di

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import me.vponomarenko.tickets.app.common.ViewModelKey
import me.vponomarenko.ticketsapp.presentation.search.ticket.recycler.FlightsAdapter
import me.vponomarenko.ticketsapp.presentation.search.ticket.viewmodel.SearchViewModel
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 03/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Module
internal class SearchModule {
    @Provides
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    fun provideViewModel(viewModel: SearchViewModel): ViewModel = viewModel

    @Singleton
    @Provides
    fun provideFlightsAdapter() = FlightsAdapter()
}