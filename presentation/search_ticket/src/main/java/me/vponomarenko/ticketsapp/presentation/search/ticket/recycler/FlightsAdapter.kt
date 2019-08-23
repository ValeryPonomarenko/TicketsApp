package me.vponomarenko.ticketsapp.presentation.search.ticket.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.vponomarenko.ticketsapp.domain.search.data.Flight

/**
 * Author: Valery Ponomarenko
 * Date: 10/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

internal class FlightsAdapter : RecyclerView.Adapter<FlightViewHolder>() {

    var flights: List<Flight>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FlightViewHolder.create(LayoutInflater.from(parent.context), parent)

    override fun getItemCount() = flights?.size ?: 0

    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        flights?.get(position)?.let(holder::onBind)
    }
}