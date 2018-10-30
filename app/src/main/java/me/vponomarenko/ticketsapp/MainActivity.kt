package me.vponomarenko.ticketsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.vponomarenko.ticketsapp.data.DataSource
import me.vponomarenko.ticketsapp.data.mappers.CityEntityToCity
import me.vponomarenko.ticketsapp.data.repositories.CitiesRepository
import me.vponomarenko.ticketsapp.domain.search.SearchCityUseCase
import me.vponomarenko.ticketsapp.presentation.search.city.view.FragmentDependencies

class MainActivity : AppCompatActivity(), FragmentDependencies {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, FragmentSearch())
                .commit()
        }
    }

    override fun provideSearchCityUseCase(): SearchCityUseCase =
        SearchCityUseCase(CitiesRepository(DataSource(), CityEntityToCity()))
}
