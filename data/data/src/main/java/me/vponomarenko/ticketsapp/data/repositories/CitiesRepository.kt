package me.vponomarenko.ticketsapp.data.repositories

import android.util.LruCache
import io.reactivex.Single
import me.vponomarenko.ticketsapp.data.IDataSource
import me.vponomarenko.ticketsapp.data.entities.CityEntity
import me.vponomarenko.ticketsapp.data.mappers.CityEntityToCity
import me.vponomarenko.ticketsapp.domain.search.api.ICitiesRepository
import me.vponomarenko.ticketsapp.domain.search.data.City
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class CitiesRepository @Inject constructor(
    private val dataSource: IDataSource,
    private val citiesCache: LruCache<String, List<CityEntity>>,
    private val mapper: CityEntityToCity
) : ICitiesRepository {

    override fun loadCities(name: String): Single<List<City>> =
        Single
            .fromCallable {
                citiesCache.get(name) ?: dataSource.getCities(name).also {
                    citiesCache.put(name, it)
                }
            }
            .map { it.map(mapper::map) }
            .delay(1, TimeUnit.SECONDS)
}