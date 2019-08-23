package me.vponomarenko.ticketsapp.presentation.search.ticket.di

import me.vponomarenko.ticketsapp.presentation.search.ticket.animation.SearchFragmentSharedUiAnimator
import me.vponomarenko.ticketsapp.presentation.search.ticket.navigation.SearchNavigation

/**
 * Author: Valery Ponomarenko
 * Date: 03/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

interface SearchComponentDeps {
    fun provideSearchNavigation(): SearchNavigation
    fun provideSearchSharedUiAnimator(): SearchFragmentSharedUiAnimator
}