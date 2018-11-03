package me.vponomarenko.ticketsapp.navigation.commands

/**
 * Author: Valery Ponomarenko
 * Date: 03/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

data class ForwardForResult(val screenName: String, val requestCode: Int, val data: Any? = null) : Command()