package me.vponomarenko.ticketsapp.presentation.search.ticket.recycler

import android.content.res.Resources
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import me.vponomarenko.ticketsapp.presentation.search.R

internal class FlightViewHolderDecorator(resources: Resources): RecyclerView.ItemDecoration() {

    private val topOffset = resources.getDimension(R.dimen.flight_top_offset).toInt()

    private val rightOffset = resources.getDimension(R.dimen.flight_right_offset).toInt()

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.top = topOffset
        outRect.right = rightOffset
    }
}