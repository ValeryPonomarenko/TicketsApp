package me.vponomarenko.ticketsapp.data.di

import dagger.Module
import dagger.Provides
import me.vponomarenko.ticketsapp.data.DataSource
import me.vponomarenko.ticketsapp.data.IDataSource
import me.vponomarenko.ticketsapp.data.mappers.CityEntityToCity
import me.vponomarenko.ticketsapp.data.mappers.FlightEntityToFlight
import me.vponomarenko.ticketsapp.data.repositories.CitiesRepository
import me.vponomarenko.ticketsapp.data.repositories.FlightsRepository
import me.vponomarenko.ticketsapp.domain.search.api.ICitiesRepository
import me.vponomarenko.ticketsapp.domain.search.api.IFlightsRepository
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun provideDataSource(): IDataSource = DataSource()

    @Singleton
    @Provides
    fun provideCitiesRepository(dataSource: IDataSource, mapper: CityEntityToCity): ICitiesRepository =
        CitiesRepository(dataSource, mapper)

    @Singleton
    @Provides
    fun provideFlightsRepository(dataSource: IDataSource, mapper: FlightEntityToFlight): IFlightsRepository =
        FlightsRepository(dataSource, mapper)
}