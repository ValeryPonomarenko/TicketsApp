package me.vponomarenko.ticketsapp.domain.search.di

import dagger.Component
import me.vponomarenko.ticketsapp.domain.common.di.SchedulersDepsIn
import me.vponomarenko.ticketsapp.domain.search.di.deps.DomainSearchDepsIn
import me.vponomarenko.ticketsapp.domain.search.di.deps.DomainSearchDepsOut
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [SchedulersDepsIn::class, DomainSearchDepsIn::class]
)
interface DomainSearchComponent : DomainSearchDepsOut {
    companion object {
        fun init(schedulersDepsIn: SchedulersDepsIn, domainDepsIn: DomainSearchDepsIn): DomainSearchComponent =
            DaggerDomainSearchComponent.builder()
                .schedulersDepsIn(schedulersDepsIn)
                .domainSearchDepsIn(domainDepsIn)
                .build()
    }
}