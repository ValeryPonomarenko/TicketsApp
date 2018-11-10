package me.vponomarenko.ticketsapp.di

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.vponomarenko.ticketsapp.animations.SharedUiElementsManager
import me.vponomarenko.ticketsapp.domain.common.di.IoScheduler
import me.vponomarenko.ticketsapp.domain.common.di.UiScheduler
import me.vponomarenko.ticketsapp.navigation.NavigationFacade
import me.vponomarenko.ticketsapp.navigation.NavigatorHolder
import me.vponomarenko.ticketsapp.presentation.search.city.animation.DestinationFragmentSharedUiAnimator
import me.vponomarenko.ticketsapp.presentation.search.city.navigation.DestinationNavigation
import me.vponomarenko.ticketsapp.presentation.search.ticket.animation.SearchFragmentSharedUiAnimator
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

    @Singleton
    @Provides
    fun provideSearchFragmentSharedUiAnimator(
        sharedUiElementsManager: SharedUiElementsManager
    ): SearchFragmentSharedUiAnimator = sharedUiElementsManager

    @Singleton
    @Provides
    fun provideDestinationFragmentSharedUiAnimator(
        sharedUiElementsManager: SharedUiElementsManager
    ): DestinationFragmentSharedUiAnimator = sharedUiElementsManager

    @Singleton
    @Provides
    @UiScheduler
    fun provideUiScheduler(): Scheduler = AndroidSchedulers.mainThread()

    @Singleton
    @Provides
    @IoScheduler
    fun provideIoScheduler(): Scheduler = Schedulers.io()
}