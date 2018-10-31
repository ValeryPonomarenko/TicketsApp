package me.vponomarenko.ticketsapp.data.di

import dagger.Component
import me.vponomarenko.ticketsapp.domain.search.di.deps.DomainSearchForCitiesDepsIn
import javax.inject.Singleton

@Singleton
@Component(
    modules = [DataModule::class]
)
interface DataComponent : DomainSearchForCitiesDepsIn {
    companion object {
        fun init(): DataComponent = DaggerDataComponent.create()
    }
}