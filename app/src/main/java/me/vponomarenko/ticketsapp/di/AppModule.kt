package me.vponomarenko.ticketsapp.di

import dagger.Module
import dagger.Provides
import me.vponomarenko.ticketsapp.navigation.NavigationFacade
import me.vponomarenko.ticketsapp.navigation.NavigatorHolder
import me.vponomarenko.ticketsapp.presentation.search.city.navigation.DestinationNavigation
import me.vponomarenko.ticketsapp.presentation.search.ticket.navigation.SearchNavigation
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 03/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideNavigatorHolder() = NavigatorHolder()

    @Singleton
    @Provides
    fun provideSearchNavigation(navigationFacade: NavigationFacade): SearchNavigation = navigationFacade

    @Singleton
    @Provides
    fun provideDestinationNavigation(navigationFacade: NavigationFacade): DestinationNavigation = navigationFacade
}