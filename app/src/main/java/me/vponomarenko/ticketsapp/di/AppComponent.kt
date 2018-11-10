package me.vponomarenko.ticketsapp.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import me.vponomarenko.ticketsapp.MainActivity
import me.vponomarenko.ticketsapp.domain.common.di.SchedulersDepsIn
import me.vponomarenko.ticketsapp.presentation.search.city.di.SearchForCityComponentDepsIn
import me.vponomarenko.ticketsapp.presentation.search.ticket.di.SearchComponentDepsIn
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 03/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Singleton
@Component(
    modules = [AppModule::class]
)
interface AppComponent : SearchComponentDepsIn, SearchForCityComponentDepsIn, SchedulersDepsIn {
    companion object {
        fun init(context: Context): AppComponent = DaggerAppComponent.builder().context(context).build()
    }

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(mainActivity: MainActivity)
}