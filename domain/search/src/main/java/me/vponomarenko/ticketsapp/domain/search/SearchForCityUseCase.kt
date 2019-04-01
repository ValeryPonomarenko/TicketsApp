package me.vponomarenko.ticketsapp.domain.search

import io.reactivex.Scheduler
import io.reactivex.Single
import me.vponomarenko.ticketsapp.domain.common.di.IoScheduler
import me.vponomarenko.ticketsapp.domain.common.di.UiScheduler
import me.vponomarenko.ticketsapp.domain.search.api.ICitiesRepository
import me.vponomarenko.ticketsapp.domain.search.data.City
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchForCityUseCase @Inject constructor(
    private val citiesRepository: ICitiesRepository,
    @IoScheduler private val ioScheduler: Scheduler,
    @UiScheduler private val uiScheduler: Scheduler
) {
    operator fun invoke(name: String): Single<List<City>> =
        if (name.isBlank()) {
            Single.just(emptyList())
        } else {
            citiesRepository.loadCities(name)
        }.apply {
            subscribeOn(ioScheduler)
            observeOn(uiScheduler)
        }
}