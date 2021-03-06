package me.vponomarenko.ticketsapp.presentation.search.city.di

import me.vponomarenko.ticketsapp.presentation.search.city.animation.DestinationFragmentSharedUiAnimator
import me.vponomarenko.ticketsapp.presentation.search.city.navigation.DestinationNavigation

/**
 * Author: Valery Ponomarenko
 * Date: 04/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

interface SearchForCityComponentDeps {
    fun provideDestinationNavigation(): DestinationNavigation
    fun provideDestinationSharedUiAnimator(): DestinationFragmentSharedUiAnimator
}