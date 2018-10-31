package me.vponomarenko.ticketsapp.presentation.search.ticket.navigation

import android.view.View

interface SearchNavigation {
    fun openDestinationSearch(sharedElement: View, transitionName: String, isFrom: Boolean)
}