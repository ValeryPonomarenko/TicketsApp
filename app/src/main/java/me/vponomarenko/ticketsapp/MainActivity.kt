package me.vponomarenko.ticketsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.vponomarenko.injectionmanager.x.XInjectionManager
import me.vponomarenko.ticketsapp.animations.SharedUiElementsManager
import me.vponomarenko.ticketsapp.di.AppComponent
import me.vponomarenko.ticketsapp.navigation.Navigator
import me.vponomarenko.ticketsapp.navigation.NavigatorHolder
import me.vponomarenko.ticketsapp.navigation.commands.AsRoot
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    internal lateinit var navigatorHolder: NavigatorHolder

    @Inject
    internal lateinit var sharedUiElementsManager: SharedUiElementsManager

    private val navigator by lazy { Navigator(this, sharedUiElementsManager) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        XInjectionManager.instance
            .findComponent<AppComponent>()
            .inject(this)
        if (savedInstanceState == null) {
            navigatorHolder.consumeCommand(AsRoot(Screen.Main))
        }
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.releaseNavigator()
    }
}
