package me.vponomarenko.ticketsapp.data.di

import android.util.LruCache
import dagger.Module
import dagger.Provides
import me.vponomarenko.ticketsapp.data.MockedDataSource
import me.vponomarenko.ticketsapp.data.DataSource
import me.vponomarenko.ticketsapp.data.entities.CityEntity
import me.vponomarenko.ticketsapp.data.repositories.CitiesRepositoryImpl
import me.vponomarenko.ticketsapp.data.repositories.FlightsRepositoryImpl
import me.vponomarenko.ticketsapp.domain.search.api.CitiesRepository
import me.vponomarenko.ticketsapp.domain.search.api.FlightsRepository
import javax.inject.Singleton

@Module
internal class DataModule {

    @Singleton
    @Provides
    fun provideDataSource(): DataSource = MockedDataSource()

    @Singleton
    @Provides
    fun provideCitiesRepository(repository: CitiesRepositoryImpl): CitiesRepository = repository

    @Singleton
    @Provides
    fun provideFlightsRepository(repository: FlightsRepositoryImpl): FlightsRepository = repository

    @Singleton
    @Provides
    fun provideCityEntityCache() = LruCache<String, List<CityEntity>>(5)

}