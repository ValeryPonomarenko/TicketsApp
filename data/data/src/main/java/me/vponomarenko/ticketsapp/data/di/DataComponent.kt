package me.vponomarenko.ticketsapp.data.di

import dagger.Component
import me.vponomarenko.ticketsapp.domain.search.di.DomainSearchDeps
import javax.inject.Singleton

@Singleton
@Component(
    modules = [DataModule::class, MappersModule::class]
)
interface DataComponent : DomainSearchDeps {
    companion object {
        fun init(): DataComponent = DaggerDataComponent.create()
    }
}