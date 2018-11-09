package me.vponomarenko.ticketsapp.data.di

import dagger.Component
import me.vponomarenko.ticketsapp.domain.search.di.deps.DomainSearchDepsIn
import javax.inject.Singleton

@Singleton
@Component(
    modules = [DataModule::class, MappersModule::class]
)
interface DataComponent : DomainSearchDepsIn {
    companion object {
        fun init(): DataComponent = DaggerDataComponent.create()
    }
}