package me.vponomarenko.ticketsapp.presentation.search.city.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.TransitionInflater
import kotlinx.android.synthetic.main.fragment_destination.*
import me.vponomarenko.injectionmanager.IHasComponent
import me.vponomarenko.injectionmanager.x.XInjectionManager
import me.vponomarenko.tickets.app.common.ViewModelFactory
import me.vponomarenko.tickets.app.common.ext.addTextChangedObservable
import me.vponomarenko.tickets.app.common.ext.observe
import me.vponomarenko.tickets.app.common.renderer.Renderer
import me.vponomarenko.ticketsapp.presentation.search.R
import me.vponomarenko.ticketsapp.presentation.search.city.animation.DestinationFragmentSharedUiAnimator
import me.vponomarenko.ticketsapp.presentation.search.city.di.SearchForCityComponent
import me.vponomarenko.ticketsapp.presentation.search.city.recycler.DestinationsAdapter
import me.vponomarenko.ticketsapp.presentation.search.city.viewmodel.DestinationViewModel
import me.vponomarenko.ticketsapp.presentation.search.city.viewstate.DestinationViewState
import javax.inject.Inject

class DestinationFragment : Fragment(), IHasComponent<SearchForCityComponent> {

    companion object {
        private const val EXTRA_IS_FROM = "search.city.isFrom"

        fun newInstance(isFrom: Boolean): Fragment =
            DestinationFragment().apply {
                arguments = Bundle().apply { putBoolean(EXTRA_IS_FROM, isFrom) }
            }
    }

    @Inject
    internal lateinit var sharedUiAnimator: DestinationFragmentSharedUiAnimator

    @Inject
    internal lateinit var adapter: DestinationsAdapter

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    @Inject
    internal lateinit var renderer: Renderer<DestinationViewState>

    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(DestinationViewModel::class.java)
    }

    private val isFrom: Boolean
        get() = arguments?.getBoolean(EXTRA_IS_FROM) ?: throw IllegalStateException()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        XInjectionManager.bindComponent(this).inject(this)
        postponeEnterTransition()
        TransitionInflater.from(requireContext()).apply {
            this@DestinationFragment.sharedElementEnterTransition = inflateTransition(android.R.transition.move)
            this@DestinationFragment.sharedElementReturnTransition = inflateTransition(android.R.transition.move)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_destination, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareView(view)
        sharedUiAnimator.animateDestination(group_destination)
        startPostponedEnterTransition()
    }

    override fun getComponent() = SearchForCityComponent.init()

    private fun prepareView(view: View) {
        editText_destination.hint = if (isFrom) getString(R.string.from) else getString(R.string.to)
        image_destination.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                if (isFrom) R.drawable.ic_flight_takeoff else R.drawable.ic_flight_land
            )
        )
        recyclerView_destinations.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@DestinationFragment.adapter
            (itemAnimator as? DefaultItemAnimator)?.supportsChangeAnimations = false
        }
        adapter.onClickListener = viewModel::onDestinationSelected
        button_close.setOnClickListener { viewModel.back() }

        viewModel.observeSearchChanges(editText_destination.addTextChangedObservable())
        viewModel.viewState.observe(viewLifecycleOwner) {
            renderer.render(view, it)
        }
    }
}