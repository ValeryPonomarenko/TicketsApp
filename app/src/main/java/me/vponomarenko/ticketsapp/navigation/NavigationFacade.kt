package me.vponomarenko.ticketsapp.navigation

import me.vponomarenko.ticketsapp.Screen
import me.vponomarenko.ticketsapp.domain.search.data.City
import me.vponomarenko.ticketsapp.navigation.commands.Back
import me.vponomarenko.ticketsapp.navigation.commands.Forward
import me.vponomarenko.ticketsapp.presentation.search.city.navigation.DestinationNavigation
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
) : SearchNavigation, DestinationNavigation {

    companion object {
        private const val REQUEST_CITY = 1000
    }

//    private val resultListeners = mutableListOf<Pair<Int, Any>>()
    private var cityResultListener: ((City) -> Unit)? = null

    override fun openDestinationSearch(isFrom: Boolean, resultListener: (City) -> Unit) {
        val screen = Screen.Destination(isFrom)
//        resultListeners.add(REQUEST_CITY to resultListener)
        cityResultListener = resultListener
        navigatorHolder.consumeCommand(Forward(screen))
    }

    override fun exitWithResult(city: City) {
        cityResultListener?.invoke(city)
        cityResultListener = null
        navigatorHolder.consumeCommand(Back())
    }
}