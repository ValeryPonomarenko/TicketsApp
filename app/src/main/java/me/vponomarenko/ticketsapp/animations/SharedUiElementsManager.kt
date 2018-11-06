package me.vponomarenko.ticketsapp.animations

import android.content.Context
import android.view.View
import androidx.core.view.ViewCompat
import me.vponomarenko.ticketsapp.presentation.search.city.animation.DestinationFragmentSharedUiAnimator
import me.vponomarenko.ticketsapp.presentation.search.ticket.animation.SearchFragmentSharedUiAnimator
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 06/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Singleton
class SharedUiElementsManager @Inject constructor(private val context: Context) :
    SearchFragmentSharedUiAnimator, DestinationFragmentSharedUiAnimator {

    companion object {
        private const val SEARCH_FROM_TRANSITION_NAME = "shared_search_from"
        private const val SEARCH_TO_TRANSITION_NAME = "shared_search_to"
    }

    private var sharedElements: List<Pair<String, View>>? = null

    override fun share(vararg views: View) {
        sharedElements = views.mapNotNull { view ->
            ViewCompat.getTransitionName(view)?.let { return@mapNotNull it to view }
        }
    }

    override fun prepareFrom(view: View) {
        ViewCompat.setTransitionName(view, SEARCH_FROM_TRANSITION_NAME)
    }

    override fun prepareTo(view: View) {
        ViewCompat.setTransitionName(view, SEARCH_TO_TRANSITION_NAME)
    }

    override fun animateDestination(view: View) {
        getTransitionElements().getOrNull(0)?.let {
            ViewCompat.setTransitionName(view, it.first)
        }
    }

    fun getTransitionElements(): List<Pair<String, View>> = sharedElements ?: emptyList()
}