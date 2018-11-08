package me.vponomarenko.ticketsapp.presentation.search.city.recycler

import androidx.recyclerview.widget.DiffUtil
import me.vponomarenko.ticketsapp.domain.search.data.City

/**
 * Author: Valery Ponomarenko
 * Date: 08/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class CityDiffUtil(
    private val old: List<City>,
    private val new: List<City>
) : DiffUtil.Callback() {

    override fun getOldListSize() = old.size

    override fun getNewListSize() = new.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        old[oldItemPosition].shortName == new[newItemPosition].shortName

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        old[oldItemPosition] == new[newItemPosition]
}