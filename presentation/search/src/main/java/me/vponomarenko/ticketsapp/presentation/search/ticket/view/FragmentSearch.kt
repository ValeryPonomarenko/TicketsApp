package me.vponomarenko.ticketsapp.presentation.search.ticket.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_search.*
import me.vponomarenko.ticketsapp.presentation.search.R
import me.vponomarenko.ticketsapp.presentation.search.ticket.navigation.SearchNavigation

class FragmentSearch : Fragment() {

    private val navigator by lazy {
        (activity as? SearchNavigation) ?: throw IllegalStateException()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_search, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ViewCompat.setTransitionName(group_destination_from, "destination_from")
        ViewCompat.setTransitionName(group_destination_to, "destination_to")
        group_destination_from.setOnClickListener {
            navigator.openDestinationSearch(group_destination_from, ViewCompat.getTransitionName(group_destination_from)!!, true)
        }
        group_destination_to.setOnClickListener {
            navigator.openDestinationSearch(group_destination_to, ViewCompat.getTransitionName(group_destination_to)!!, false)
        }
        button_search.setOnClickListener {
            motion.transitionToEnd()
        }
    }
}