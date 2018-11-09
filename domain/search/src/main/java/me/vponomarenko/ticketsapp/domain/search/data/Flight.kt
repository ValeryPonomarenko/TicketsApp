package me.vponomarenko.ticketsapp.domain.search.data

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
)