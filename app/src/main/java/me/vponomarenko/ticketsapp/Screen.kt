package me.vponomarenko.ticketsapp

/**
 * Author: Valery Ponomarenko
 * Date: 03/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

sealed class Screen {
    object Main : Screen()

    data class Destination(val isFrom: Boolean) : Screen()
}