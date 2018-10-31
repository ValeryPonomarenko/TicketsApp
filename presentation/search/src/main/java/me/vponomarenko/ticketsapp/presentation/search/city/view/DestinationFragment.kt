package me.vponomarenko.ticketsapp.presentation.search.city.view

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_destination.*
import me.vponomarenko.injectionmanager.IHasComponent
import me.vponomarenko.injectionmanager.x.XInjectionManager
import me.vponomarenko.ticketsapp.domain.search.SearchForCityUseCase
import me.vponomarenko.ticketsapp.presentation.search.R
import me.vponomarenko.ticketsapp.presentation.search.city.di.SearchForCityComponent
import javax.inject.Inject

class DestinationFragment : Fragment(), IHasComponent {

    @Inject
    internal lateinit var useCase: SearchForCityUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        XInjectionManager.instance
            .bindComponent<SearchForCityComponent>(this)
            .inject(this)
        postponeEnterTransition()
        sharedElementEnterTransition =
            TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_destination, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ViewCompat.setTransitionName(editText_destination, "destination")
        startPostponedEnterTransition()
        editText_destination.text = useCase("").joinToString(separator = ", ") { it.name }
    }

    override fun getComponent(): SearchForCityComponent = SearchForCityComponent.init()
}