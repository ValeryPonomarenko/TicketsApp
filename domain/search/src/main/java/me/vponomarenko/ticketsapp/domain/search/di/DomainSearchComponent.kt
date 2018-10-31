package me.vponomarenko.ticketsapp.domain.search.di

import dagger.Component
import me.vponomarenko.ticketsapp.domain.search.di.deps.DomainSearchForCitiesDepsIn
import me.vponomarenko.ticketsapp.domain.search.di.deps.DomainSearchForCitiesDepsOut
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [DomainSearchForCitiesDepsIn::class],
    modules = [UseCaseModule::class]
)
interface DomainSearchComponent : DomainSearchForCitiesDepsOut {
    companion object {
        fun init(depsIn: DomainSearchForCitiesDepsIn): DomainSearchComponent =
            DaggerDomainSearchComponent.builder()
                .domainSearchForCitiesDepsIn(depsIn)
                .build()
    }
}