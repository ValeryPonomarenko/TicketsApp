package me.vponomarenko.ticketsapp.presentation.search.city.di

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import me.vponomarenko.tickets.app.common.ViewModelKey
import me.vponomarenko.ticketsapp.presentation.search.city.recycler.DestinationsAdapter
import me.vponomarenko.ticketsapp.presentation.search.city.viewmodel.DestinationViewModel
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 08/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Module
internal class SearchForCityModule {
    @Singleton
    @Provides
    fun provideDestinationsAdapter() = DestinationsAdapter()

    @Provides
    @IntoMap
    @ViewModelKey(DestinationViewModel::class)
    fun provideViewModel(viewModel: DestinationViewModel): ViewModel = viewModel
}