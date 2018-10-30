package me.vponomarenko.ticketsapp.data

import me.vponomarenko.ticketsapp.data.entities.CityEntity

interface IDataSource {
    fun getCities(name: String): List<CityEntity>
}