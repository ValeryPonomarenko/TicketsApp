package me.vponomarenko.ticketsapp.domain.search.di

import dagger.Module
import dagger.Provides
import me.vponomarenko.ticketsapp.domain.search.SearchForCityUseCase
import me.vponomarenko.ticketsapp.domain.search.api.ICitiesRepository
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Singleton
    @Provides
    fun provideSearchForCityUseCase(repository: ICitiesRepository): SearchForCityUseCase =
        SearchForCityUseCase(repository)
}