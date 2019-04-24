package me.vponomarenko.ticketsapp.presentation.search.ticket.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_search.*
import me.vponomarenko.injectionmanager.IHasComponent
import me.vponomarenko.injectionmanager.x.XInjectionManager
import me.vponomarenko.tickets.app.common.ViewModelFactory
import me.vponomarenko.tickets.app.common.ext.observe
import me.vponomarenko.tickets.app.common.ext.render
import me.vponomarenko.tickets.app.common.renderer.Renderer
import me.vponomarenko.ticketsapp.presentation.search.R
import me.vponomarenko.ticketsapp.presentation.search.ticket.animation.SearchFragmentSharedUiAnimator
import me.vponomarenko.ticketsapp.presentation.search.ticket.di.SearchComponent
import me.vponomarenko.ticketsapp.presentation.search.ticket.recycler.FlightViewHolderDecorator
import me.vponomarenko.ticketsapp.presentation.search.ticket.recycler.FlightsAdapter
import me.vponomarenko.ticketsapp.presentation.search.ticket.viewmodel.SearchViewModel
import me.vponomarenko.ticketsapp.presentation.search.ticket.viewstate.SearchViewState
import javax.inject.Inject

class SearchFragment : Fragment(), IHasComponent<SearchComponent> {

    @Inject
    internal lateinit var sharedUiAnimator: SearchFragmentSharedUiAnimator

    @Inject
    internal lateinit var adapter: FlightsAdapter

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    @Inject
    internal lateinit var renderer: Renderer<SearchViewState>

    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(SearchViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        XInjectionManager
            .bindComponent(this)
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_search, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedUiAnimator.prepareFrom(group_destination_from)
        sharedUiAnimator.prepareTo(group_destination_to)

        group_destination_from.setOnClickListener {
            sharedUiAnimator.share(it)
            viewModel.onDepartingFromClick()
        }
        group_destination_to.setOnClickListener {
            sharedUiAnimator.share(it)
            viewModel.onFlightToClick()
        }

        button_search.setOnClickListener { viewModel.search() }
        button_close.setOnClickListener { viewModel.changeSearch() }

        recyclerView_flights.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@SearchFragment.adapter
            addItemDecoration(FlightViewHolderDecorator(resources))
        }
        viewModel.viewState.render(this, renderer, view)
    }

    override fun getComponent(): SearchComponent = SearchComponent.init()
}