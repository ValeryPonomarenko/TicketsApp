package me.vponomarenko.ticketsapp.domain.search.di

import dagger.Component
import me.vponomarenko.ticketsapp.domain.search.di.deps.DomainSearchDepsIn
import me.vponomarenko.ticketsapp.domain.search.di.deps.DomainSearchDepsOut
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [DomainSearchDepsIn::class],
    modules = [UseCaseModule::class]
)
interface DomainSearchComponent : DomainSearchDepsOut {
    companion object {
        fun init(depsIn: DomainSearchDepsIn): DomainSearchComponent =
            DaggerDomainSearchComponent.builder()
                .domainSearchDepsIn(depsIn)
                .build()
    }
}