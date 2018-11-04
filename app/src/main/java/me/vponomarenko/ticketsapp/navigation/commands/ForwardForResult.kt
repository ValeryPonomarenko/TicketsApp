package me.vponomarenko.ticketsapp.navigation.commands

import me.vponomarenko.ticketsapp.Screen

/**
 * Author: Valery Ponomarenko
 * Date: 03/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

data class ForwardForResult(val screen: Screen, val requestCode: Int) : Command()