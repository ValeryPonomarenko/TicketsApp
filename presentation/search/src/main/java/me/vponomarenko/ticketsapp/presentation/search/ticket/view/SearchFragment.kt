package me.vponomarenko.ticketsapp.presentation.search.ticket.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_search.*
import me.vponomarenko.injectionmanager.IHasComponent
import me.vponomarenko.injectionmanager.x.XInjectionManager
import me.vponomarenko.tickets.app.common.ViewModelFactory
import me.vponomarenko.ticketsapp.presentation.search.R
import me.vponomarenko.ticketsapp.presentation.search.ticket.di.SearchComponent
import me.vponomarenko.ticketsapp.presentation.search.ticket.navigation.SearchNavigation
import me.vponomarenko.ticketsapp.presentation.search.ticket.viewmodel.SearchViewModel
import javax.inject.Inject

class SearchFragment : Fragment(), IHasComponent {

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    @Inject
    internal lateinit var navigator: SearchNavigation

    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(SearchViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        XInjectionManager.instance
            .bindComponent<SearchComponent>(this)
            .inject(this)
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
            viewModel.onDepartingFromClick()
        }
        group_destination_to.setOnClickListener {
            viewModel.onFlightToClick()
        }
        button_search.setOnClickListener {
            motion.transitionToEnd()
        }
    }

    override fun getComponent(): SearchComponent = SearchComponent.init()
}