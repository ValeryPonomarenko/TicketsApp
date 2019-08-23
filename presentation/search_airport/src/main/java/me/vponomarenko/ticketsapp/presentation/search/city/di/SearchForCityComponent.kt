package me.vponomarenko.ticketsapp.presentation.search.city.di

import dagger.Component
import me.vponomarenko.injectionmanager.x.XInjectionManager
import me.vponomarenko.ticketsapp.domain.search.di.DomainSearchApi
import me.vponomarenko.ticketsapp.presentation.search.city.view.DestinationFragment
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [DomainSearchApi::class, SearchForCityComponentDeps::class],
    modules = [SearchForCityModule::class, SearchForCityViewStateRenderersModule::class]
)
interface SearchForCityComponent {
    fun inject(fragment: DestinationFragment)
    companion object {
        fun init(): SearchForCityComponent =
            DaggerSearchForCityComponent.builder()
                .domainSearchApi(XInjectionManager.findComponent())
                .searchForCityComponentDeps(XInjectionManager.findComponent())
                .build()
    }
}