package me.vponomarenko.ticketsapp.data.di

import android.util.LruCache
import dagger.Module
import dagger.Provides
import me.vponomarenko.ticketsapp.data.DataSource
import me.vponomarenko.ticketsapp.data.IDataSource
import me.vponomarenko.ticketsapp.data.entities.CityEntity
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
    fun provideCitiesRepository(repository: CitiesRepository): ICitiesRepository = repository

    @Singleton
    @Provides
    fun provideFlightsRepository(repository: FlightsRepository): IFlightsRepository = repository

    @Singleton
    @Provides
    fun provideCityEntityCache() = LruCache<String, List<CityEntity>>(5)

}