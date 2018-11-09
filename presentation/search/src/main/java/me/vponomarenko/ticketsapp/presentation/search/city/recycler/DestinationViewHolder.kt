package me.vponomarenko.ticketsapp.presentation.search.city.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_destination.*
import me.vponomarenko.ticketsapp.presentation.search.R

/**
 * Author: Valery Ponomarenko
 * Date: 08/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class DestinationViewHolder(
    override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    companion object {
        fun create(inflater: LayoutInflater, container: ViewGroup): DestinationViewHolder =
            DestinationViewHolder(inflater.inflate(R.layout.item_destination, container, false))
    }

    fun onBind(city: SpannableCity, onClickListener: OnDestinationClick) {
        text_destination_name.text = city.spannable
        containerView.setOnClickListener {
            onClickListener(city)
        }
    }

}