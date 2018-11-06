package me.vponomarenko.ticketsapp.presentation.search.city.view

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import kotlinx.android.synthetic.main.fragment_destination.*
import me.vponomarenko.injectionmanager.IHasComponent
import me.vponomarenko.injectionmanager.x.XInjectionManager
import me.vponomarenko.ticketsapp.domain.search.data.City
import me.vponomarenko.ticketsapp.presentation.search.R
import me.vponomarenko.ticketsapp.presentation.search.city.animation.DestinationFragmentSharedUiAnimator
import me.vponomarenko.ticketsapp.presentation.search.city.di.SearchForCityComponent
import me.vponomarenko.ticketsapp.presentation.search.city.navigation.DestinationNavigation
import javax.inject.Inject

class DestinationFragment : Fragment(), IHasComponent {

    companion object {
        private const val EXTRA_IS_FROM = "search.city.isFrom"

        fun newInstance(isFrom: Boolean): Fragment =
            DestinationFragment().apply {
                val args = Bundle()
                args.putBoolean(EXTRA_IS_FROM, isFrom)
                this.arguments = args
            }
    }

    @Inject
    internal lateinit var navigation: DestinationNavigation

    @Inject
    internal lateinit var sharedUiAnimator: DestinationFragmentSharedUiAnimator

    private val isFrom: Boolean
        get() = arguments?.getBoolean(EXTRA_IS_FROM) ?: throw IllegalStateException()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        XInjectionManager.instance
            .bindComponent<SearchForCityComponent>(this)
            .inject(this)
        postponeEnterTransition()
        with (TransitionInflater.from(requireContext())) {
            this@DestinationFragment.sharedElementEnterTransition = inflateTransition(android.R.transition.move)
            this@DestinationFragment.sharedElementReturnTransition = inflateTransition(android.R.transition.move)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_destination, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareView()
        sharedUiAnimator.animateDestination(group_destination)
        startPostponedEnterTransition()
        Handler().postDelayed({
            navigation.exitWithResult(City("Moscow", "MSK"))
        }, 3000)
    }

    override fun getComponent(): SearchForCityComponent = SearchForCityComponent.init()

    private fun prepareView() {
        editText_destination.hint = if (isFrom) getString(R.string.from) else getString(R.string.to)
        image_destination.setImageDrawable(
            ContextCompat.getDrawable(requireContext(), if (isFrom) R.drawable.ic_flight_takeoff else R.drawable.ic_flight_land)
        )
    }
}