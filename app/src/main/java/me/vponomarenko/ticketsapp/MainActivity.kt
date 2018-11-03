package me.vponomarenko.ticketsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.vponomarenko.injectionmanager.x.XInjectionManager
import me.vponomarenko.ticketsapp.di.AppComponent
import me.vponomarenko.ticketsapp.navigation.Navigator
import me.vponomarenko.ticketsapp.navigation.NavigatorHolder
import me.vponomarenko.ticketsapp.presentation.search.ticket.view.SearchFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    internal lateinit var navigatorHolder: NavigatorHolder

    private val navigator by lazy { Navigator(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        XInjectionManager.instance
            .findComponent<AppComponent>()
            .inject(this)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, SearchFragment())
                .commit()
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

//    override fun openDestinationSearch(sharedElement: View, transitionName: String, isFrom: Boolean) {
//        supportFragmentManager
//            .beginTransaction()
//            .addSharedElement(sharedElement, transitionName)
//            .replace(R.id.fragmentContainer, DestinationFragment.newInstance(isFrom, transitionName))
//            .addToBackStack("From")
//            .commit()
//    }
}
