package me.vponomarenko.ticketsapp.data.di

import dagger.Module
import dagger.Provides
import me.vponomarenko.ticketsapp.data.mappers.AirlineEntityToAirline
import me.vponomarenko.ticketsapp.data.mappers.CityEntityToCity
import me.vponomarenko.ticketsapp.data.mappers.FlightEntityToFlight
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 10/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Module
internal class MappersModule {
    @Singleton
    @Provides
    fun provideCityEntityToCity() = CityEntityToCity()

    @Singleton
    @Provides
    fun provideAirlineEntityToAirline() = AirlineEntityToAirline()

    @Singleton
    @Provides
    fun provideFlightEntityToFlight(
        cityEntityToCity: CityEntityToCity,
        airlineEntityToAirline: AirlineEntityToAirline
    ) = FlightEntityToFlight(cityEntityToCity, airlineEntityToAirline)
}