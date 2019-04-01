package me.vponomarenko.ticketsapp.presentation.search.city.di

import dagger.Component
import me.vponomarenko.injectionmanager.x.XInjectionManager
import me.vponomarenko.ticketsapp.domain.search.di.deps.DomainSearchDepsOut
import me.vponomarenko.ticketsapp.presentation.search.city.view.DestinationFragment
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [DomainSearchDepsOut::class, SearchForCityComponentDepsIn::class],
    modules = [SearchForCityModule::class, SearchForCityViewStateRenderersModule::class]
)
interface SearchForCityComponent {
    fun inject(fragment: DestinationFragment)
    companion object {
        fun init(): SearchForCityComponent =
            DaggerSearchForCityComponent.builder()
                .domainSearchDepsOut(XInjectionManager.findComponent())
                .searchForCityComponentDepsIn(XInjectionManager.findComponent())
                .build()
    }
}