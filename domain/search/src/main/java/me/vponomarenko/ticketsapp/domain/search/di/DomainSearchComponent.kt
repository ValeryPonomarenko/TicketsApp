package me.vponomarenko.ticketsapp.domain.search.di

import dagger.Component
import me.vponomarenko.ticketsapp.domain.common.di.SchedulersDeps
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [SchedulersDeps::class, DomainSearchDeps::class]
)
interface DomainSearchComponent : DomainSearchApi {
    companion object {
        fun init(schedulersDepsIn: SchedulersDeps, domainDepsIn: DomainSearchDeps): DomainSearchComponent =
            DaggerDomainSearchComponent.builder()
                .schedulersDeps(schedulersDepsIn)
                .domainSearchDeps(domainDepsIn)
                .build()
    }
}