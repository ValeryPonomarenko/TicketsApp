package me.vponomarenko.ticketsapp.presentation.search.ticket.renderer.states

import android.view.View
import android.widget.Toast
import me.vponomarenko.ticketsapp.presentation.search.ticket.viewstate.SearchViewState

class ErrorWhileEnteringViewStateRenderer : EnteringViewStateRenderer() {
	override fun render(view: View, viewState: SearchViewState) {
		super.render(view, viewState)
		Toast.makeText(view.context, "Oops! Did you enter all the cities?", Toast.LENGTH_LONG).show()
	}
}