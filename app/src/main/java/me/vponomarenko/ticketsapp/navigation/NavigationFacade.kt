package me.vponomarenko.ticketsapp.navigation

import me.vponomarenko.ticketsapp.Screens
import me.vponomarenko.ticketsapp.navigation.commands.ForwardForResult
import me.vponomarenko.ticketsapp.presentation.search.ticket.navigation.SearchNavigation
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 03/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class NavigationFacade @Inject constructor(
    private val navigatorHolder: NavigatorHolder
) : SearchNavigation {
    override fun openDestinationSearch(isFrom: Boolean) {
        navigatorHolder.consumeCommand(ForwardForResult(Screens.DESTINATION, 0xC0DE, data = isFrom))
    }
}