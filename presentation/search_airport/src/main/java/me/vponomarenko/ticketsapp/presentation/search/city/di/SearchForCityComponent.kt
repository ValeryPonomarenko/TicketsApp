package me.vponomarenko.ticketsapp.presentation.search.city.di

import dagger.Component
import me.vponomarenko.injectionmanager.IHasComponent
import me.vponomarenko.injectionmanager.x.XInjectionManager
import me.vponomarenko.ticketsapp.domain.search.di.DomainSearchApi
import me.vponomarenko.ticketsapp.presentation.search.city.view.DestinationFragment
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [DomainSearchApi::class, SearchForCityComponentDeps::class],
    modules = [SearchForCityModule::class, SearchForCityViewStateRenderersModule::class]
)
internal interface SearchForCityComponent {

    class Initializer : IHasComponent<SearchForCityComponent> {
        override fun getComponent(): SearchForCityComponent =
            DaggerSearchForCityComponent.builder()
                .domainSearchApi(XInjectionManager.findComponent())
                .searchForCityComponentDeps(XInjectionManager.findComponent())
                .build()
    }

    fun inject(fragment: DestinationFragment)
}