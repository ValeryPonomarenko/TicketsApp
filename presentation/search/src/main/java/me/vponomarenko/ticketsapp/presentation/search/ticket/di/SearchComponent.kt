package me.vponomarenko.ticketsapp.presentation.search.ticket.di

import dagger.Component
import me.vponomarenko.injectionmanager.x.XInjectionManager
import me.vponomarenko.ticketsapp.presentation.search.ticket.view.SearchFragment
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 03/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Singleton
@Component(
    dependencies = [SearchComponentDepsIn::class],
    modules = [SearchModule::class]
)
interface SearchComponent {

    companion object {
        fun init(): SearchComponent =
            DaggerSearchComponent.builder()
                .searchComponentDepsIn(XInjectionManager.instance.findComponent())
                .build()
    }

    fun inject(fragment: SearchFragment)
}