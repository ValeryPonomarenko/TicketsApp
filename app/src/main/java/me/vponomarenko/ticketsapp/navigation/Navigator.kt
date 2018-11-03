package me.vponomarenko.ticketsapp.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import me.vponomarenko.ticketsapp.MainActivity
import me.vponomarenko.ticketsapp.R
import me.vponomarenko.ticketsapp.Screens
import me.vponomarenko.ticketsapp.navigation.commands.Command
import me.vponomarenko.ticketsapp.navigation.commands.Forward
import me.vponomarenko.ticketsapp.presentation.search.city.view.DestinationFragment

class Navigator(private val activity: MainActivity) {

    private val fragmentManager: FragmentManager
        get() = activity.supportFragmentManager

    fun consumeCommand(command: Command) {
        when (command) {
            is Forward -> when (command.screenName) {
                Screens.DESTINATION ->
                    openFragment(
                        DestinationFragment.newInstance(command.data as? Boolean ?: false, "empty")
                    )
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