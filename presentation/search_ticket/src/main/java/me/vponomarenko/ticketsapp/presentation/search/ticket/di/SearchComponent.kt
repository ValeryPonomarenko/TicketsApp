package me.vponomarenko.ticketsapp.presentation.search.ticket.di

import dagger.Component
import me.vponomarenko.injectionmanager.IHasComponent
import me.vponomarenko.injectionmanager.x.XInjectionManager
import me.vponomarenko.ticketsapp.domain.search.di.DomainSearchApi
import me.vponomarenko.ticketsapp.presentation.search.ticket.view.SearchFragment
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 03/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Singleton
@Component(
    dependencies = [DomainSearchApi::class, SearchComponentDeps::class],
    modules = [SearchModule::class, SearchViewStateRenderersModule::class]
)
internal interface SearchComponent {

    class Initializer : IHasComponent<SearchComponent> {
        override fun getComponent(): SearchComponent =
            DaggerSearchComponent.builder()
                .domainSearchApi(XInjectionManager.findComponent())
                .searchComponentDeps(XInjectionManager.findComponent())
                .build()
    }

    fun inject(fragment: SearchFragment)
}