package me.vponomarenko.ticketsapp.presentation.search.city.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import me.vponomarenko.ticketsapp.domain.search.data.City

/**
 * Author: Valery Ponomarenko
 * Date: 08/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class DestinationsAdapter : RecyclerView.Adapter<DestinationViewHolder>() {

    private var destinations = listOf<City>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DestinationViewHolder.create(LayoutInflater.from(parent.context), parent)

    override fun getItemCount() = destinations.size

    override fun onBindViewHolder(holder: DestinationViewHolder, position: Int) {
        destinations.getOrNull(position)?.let { holder.onBind(it) }
    }

    fun update(destinations: List<City>) {
        val diffResult = DiffUtil.calculateDiff(CityDiffUtil(this.destinations, destinations))
        diffResult.dispatchUpdatesTo(this)
        this.destinations = destinations
    }
}