package me.vponomarenko.ticketsapp.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import me.vponomarenko.ticketsapp.MainActivity
import me.vponomarenko.ticketsapp.R
import me.vponomarenko.ticketsapp.Screen
import me.vponomarenko.ticketsapp.navigation.commands.AsRoot
import me.vponomarenko.ticketsapp.navigation.commands.Command
import me.vponomarenko.ticketsapp.navigation.commands.Forward
import me.vponomarenko.ticketsapp.presentation.search.city.view.DestinationFragment
import me.vponomarenko.ticketsapp.presentation.search.ticket.view.SearchFragment

class Navigator(private val activity: MainActivity) {

    private val fragmentManager: FragmentManager
        get() = activity.supportFragmentManager

    fun consumeCommand(command: Command) {
        when (command) {
            is Forward -> when (command.screen) {
                is Screen.Destination ->
                    openFragment(DestinationFragment.newInstance(command.screen.isFrom, "empty"))
            }
            is AsRoot -> when (command.screen) {
                is Screen.Main -> openFragment(SearchFragment(), false)
            }
        }
    }

    private fun openFragment(fragment: Fragment, addToBackStack: Boolean = true) {
        activity.supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .apply {
                if (addToBackStack) addToBackStack(null)
            }
            .commit()
    }

    private fun clearBackstack() {
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
}