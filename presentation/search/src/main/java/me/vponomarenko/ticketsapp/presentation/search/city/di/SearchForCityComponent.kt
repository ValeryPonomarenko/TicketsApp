package me.vponomarenko.ticketsapp.presentation.search.city.di

import dagger.Component
import me.vponomarenko.injectionmanager.x.XInjectionManager
import me.vponomarenko.ticketsapp.domain.search.di.deps.DomainSearchForCitiesDepsOut
import me.vponomarenko.ticketsapp.presentation.search.city.view.DestinationFragment
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [DomainSearchForCitiesDepsOut::class],
    modules = []
)
interface SearchForCityComponent {
    fun inject(fragment: DestinationFragment)
    companion object {
        fun init(): SearchForCityComponent =
            DaggerSearchForCityComponent.builder()
                .domainSearchForCitiesDepsOut(XInjectionManager.instance.findComponent())
                .build()
    }
}