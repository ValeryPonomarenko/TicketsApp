package me.vponomarenko.ticketsapp.navigation

import me.vponomarenko.ticketsapp.Screen
import me.vponomarenko.ticketsapp.navigation.commands.ForwardForResult
import me.vponomarenko.ticketsapp.presentation.search.ticket.navigation.SearchNavigation
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 03/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Singleton
class NavigationFacade @Inject constructor(
    private val navigatorHolder: NavigatorHolder
) : SearchNavigation {
    override fun openDestinationSearch(isFrom: Boolean) {
        navigatorHolder.consumeCommand(ForwardForResult(Screen.Destination(isFrom), 0xC0DE))
    }
}