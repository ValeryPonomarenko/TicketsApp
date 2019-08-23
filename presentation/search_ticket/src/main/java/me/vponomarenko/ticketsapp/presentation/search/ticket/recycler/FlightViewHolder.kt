package me.vponomarenko.ticketsapp.presentation.search.ticket.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_flight.*
import me.vponomarenko.tickets.app.common.ext.getString
import me.vponomarenko.ticketsapp.domain.search.data.Flight
import me.vponomarenko.ticketsapp.presentation.search.R
import java.text.SimpleDateFormat
import java.util.Locale

/**
 * Author: Valery Ponomarenko
 * Date: 10/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

internal class FlightViewHolder(
    override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    companion object {
        fun create(inflater: LayoutInflater, container: ViewGroup) =
            FlightViewHolder(inflater.inflate(R.layout.item_flight, container, false))
    }

    fun onBind(flight: Flight) {
        with(SimpleDateFormat(getString(R.string.date_format_short), Locale.getDefault())) {
            text_time_from.text = format(flight.dateFrom)
            text_time_to.text = format(flight.dateTo)
        }
        text_from.text = flight.from.shortName
        text_to.text = flight.to.shortName
        text_price.text = getString(R.string.cost_format, flight.cost)
        val diff = flight.dateTo.time - flight.dateFrom.time
        val seconds = diff / 1000
        val minutes = seconds / 60
        val hours = minutes / 60
        text_duration.text = getString(R.string.duration_format_short, hours, minutes - hours * 60)
    }
}