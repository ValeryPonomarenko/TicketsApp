package me.vponomarenko.ticketsapp.presentation.search.ticket.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_search.*
import me.vponomarenko.injectionmanager.IHasComponent
import me.vponomarenko.injectionmanager.x.XInjectionManager
import me.vponomarenko.tickets.app.common.ViewModelFactory
import me.vponomarenko.ticketsapp.presentation.search.R
import me.vponomarenko.ticketsapp.presentation.search.ticket.animation.SearchFragmentSharedUiAnimator
import me.vponomarenko.ticketsapp.presentation.search.ticket.di.SearchComponent
import me.vponomarenko.ticketsapp.presentation.search.ticket.viewmodel.SearchViewModel
import me.vponomarenko.ticketsapp.presentation.search.ticket.viewstate.SearchViewState
import javax.inject.Inject

class SearchFragment : Fragment(), IHasComponent {

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    @Inject
    internal lateinit var sharedUiAnimator: SearchFragmentSharedUiAnimator

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
        button_search.setOnClickListener { motion.transitionToEnd() }
        observeViewModel()
    }

    override fun getComponent(): SearchComponent = SearchComponent.init()

    private fun observeViewModel() {
        viewModel.viewState.observe(this, Observer<SearchViewState> {
            when (it) {
                is SearchViewState.Entering -> {
                    text_destination_from.text = it.from.name
                    text_small_from.text = it.from.shortName
                    text_destination_to.text = it.to.name
                    text_small_to.text = it.to.shortName
                }
            }
        })
    }
}