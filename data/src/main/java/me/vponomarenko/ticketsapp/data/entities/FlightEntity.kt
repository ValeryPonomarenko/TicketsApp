package me.vponomarenko.ticketsapp.data.entities

import java.util.Date

/**
 * Author: Valery Ponomarenko
 * Date: 10/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

internal data class FlightEntity(
    val dateFrom: Date,
    val dateTo: Date,
    val from: CityEntity,
    val to: CityEntity,
    val cost: Int,
    val airline: AirlineEntity
)