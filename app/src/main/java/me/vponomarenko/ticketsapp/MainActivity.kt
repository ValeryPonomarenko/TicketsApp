package me.vponomarenko.ticketsapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import me.vponomarenko.ticketsapp.presentation.search.city.view.DestinationFragment
import me.vponomarenko.ticketsapp.presentation.search.ticket.navigation.SearchNavigation
import me.vponomarenko.ticketsapp.presentation.search.ticket.view.SearchFragment

class MainActivity : AppCompatActivity(), SearchNavigation {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, SearchFragment())
                .commit()
        }
    }

    override fun openDestinationSearch(sharedElement: View, transitionName: String, isFrom: Boolean) {
        supportFragmentManager
            .beginTransaction()
            .addSharedElement(sharedElement, transitionName)
            .replace(R.id.fragmentContainer, DestinationFragment.newInstance(isFrom, transitionName))
            .addToBackStack("From")
            .commit()
    }
}
