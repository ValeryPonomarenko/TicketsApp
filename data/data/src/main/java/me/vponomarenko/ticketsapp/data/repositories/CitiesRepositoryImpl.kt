package me.vponomarenko.ticketsapp.data.repositories

import android.util.LruCache
import io.reactivex.Single
import me.vponomarenko.ticketsapp.data.DataSource
import me.vponomarenko.ticketsapp.data.entities.CityEntity
import me.vponomarenko.ticketsapp.data.mappers.CityEntityToCity
import me.vponomarenko.ticketsapp.domain.search.api.CitiesRepository
import me.vponomarenko.ticketsapp.domain.search.data.City
import java.util.concurrent.TimeUnit
import javax.inject.Inject

internal class CitiesRepositoryImpl @Inject constructor(
    private val dataSource: DataSource,
    private val citiesCache: LruCache<String, List<CityEntity>>,
    private val mapper: CityEntityToCity
) : CitiesRepository {

    override fun loadCities(name: String): Single<List<City>> =
        getSource(name)
            .map { it.map(mapper::map) }
            .delay(1, TimeUnit.SECONDS)

    private fun getSource(name: String): Single<List<CityEntity>> =
        citiesCache.get(name)?.run { Single.just(this) }
            ?: dataSource.getCities(name).doOnSuccess { citiesCache.put(name, it) }
}