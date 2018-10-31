package me.vponomarenko.ticketsapp

import android.app.Application
import me.vponomarenko.injectionmanager.IHasComponent
import me.vponomarenko.injectionmanager.x.XInjectionManager
import me.vponomarenko.ticketsapp.data.di.DataComponent
import me.vponomarenko.ticketsapp.domain.search.di.DomainSearchComponent

class TicketsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        XInjectionManager.instance.init(this)
        initComponents()
    }

    private fun initComponents() {
        XInjectionManager.instance
            .bindComponentToCustomLifecycle<DataComponent>(
                object : IHasComponent {
                    override fun getComponent(): DataComponent =
                        DataComponent.init()
                }
            )
        XInjectionManager.instance
            .bindComponentToCustomLifecycle<DomainSearchComponent>(
                object : IHasComponent {
                    override fun getComponent(): DomainSearchComponent =
                        DomainSearchComponent.init(XInjectionManager.instance.findComponent())
                }
            )
    }
}