package me.vponomarenko.ticketsapp

import android.app.Application
import me.vponomarenko.injectionmanager.IHasComponent
import me.vponomarenko.injectionmanager.x.XInjectionManager
import me.vponomarenko.ticketsapp.data.di.DataComponent
import me.vponomarenko.ticketsapp.di.AppComponent
import me.vponomarenko.ticketsapp.domain.search.di.DomainSearchComponent

class TicketsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        XInjectionManager.instance.init(this)
        initComponents()
    }

    private fun initComponents() {
        with(XInjectionManager.instance) {
            bindComponentToCustomLifecycle<AppComponent>(
                object : IHasComponent {
                    override fun getComponent(): AppComponent =
                        AppComponent.init(this@TicketsApplication)
                }
            )
            bindComponentToCustomLifecycle<DataComponent>(
                object : IHasComponent {
                    override fun getComponent(): DataComponent =
                        DataComponent.init()
                }
            )
            bindComponentToCustomLifecycle<DomainSearchComponent>(
                object : IHasComponent {
                    override fun getComponent(): DomainSearchComponent =
                        DomainSearchComponent.init(XInjectionManager.instance.findComponent())
                }
            )
        }
    }
}