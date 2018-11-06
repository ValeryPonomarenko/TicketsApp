package me.vponomarenko.ticketsapp.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import me.vponomarenko.ticketsapp.MainActivity
import me.vponomarenko.ticketsapp.R
import me.vponomarenko.ticketsapp.Screen
import me.vponomarenko.ticketsapp.animations.SharedUiElementsManager
import me.vponomarenko.ticketsapp.navigation.commands.AsRoot
import me.vponomarenko.ticketsapp.navigation.commands.Back
import me.vponomarenko.ticketsapp.navigation.commands.Command
import me.vponomarenko.ticketsapp.navigation.commands.Forward
import me.vponomarenko.ticketsapp.presentation.search.city.view.DestinationFragment
import me.vponomarenko.ticketsapp.presentation.search.ticket.view.SearchFragment

class Navigator constructor(
    private val activity: MainActivity,
    private val sharedUiElementsManager: SharedUiElementsManager
) {

    private val fragmentManager: FragmentManager
        get() = activity.supportFragmentManager

    fun consumeCommand(command: Command) {
        when (command) {
            is Forward -> when (command.screen) {
                is Screen.Destination ->
                    openFragment(DestinationFragment.newInstance(command.screen.isFrom))
            }
            is AsRoot -> when (command.screen) {
                is Screen.Main -> {
                    clearBackstack()
                    openFragment(SearchFragment(), false)
                }
            }
            is Back -> popFragment()
        }
    }

    private fun openFragment(fragment: Fragment, addToBackStack: Boolean = true) {
        fragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .apply {
                sharedUiElementsManager.getTransitionElements().forEach {
                    addSharedElement(it.second, it.first)
                }
            }
            .apply {
                if (addToBackStack) addToBackStack(null)
            }
            .commit()
    }

    private fun popFragment() {
        fragmentManager.popBackStack()
    }

    private fun clearBackstack() {
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
}