package me.vponomarenko.ticketsapp.presentation.search.city.navigation

import me.vponomarenko.ticketsapp.domain.search.entities.City

/**
 * Author: Valery Ponomarenko
 * Date: 04/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

interface DestinationNavigation {
    fun exitWithResult(city: City)
    fun exit()
}