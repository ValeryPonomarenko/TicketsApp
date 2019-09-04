package me.vponomarenko.ticketsapp.domain.search.entities

import java.util.Date

/**
 * Author: Valery Ponomarenko
 * Date: 10/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

data class Flight(
    val dateFrom: Date,
    val dateTo: Date,
    val from: City,
    val to: City,
    val cost: Int,
    val airline: Airline
) {
    val flightDuration by lazy {
        val diff = dateTo.time - dateFrom.time
        val seconds = diff / 1000
        val minutes = seconds / 60
        val hours = minutes / 60
        FlightDuration(hours, minutes - hours * 60)
    }
}