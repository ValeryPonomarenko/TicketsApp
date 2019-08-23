package me.vponomarenko.ticketsapp.presentation.search.city.recycler

import androidx.recyclerview.widget.DiffUtil

/**
 * Author: Valery Ponomarenko
 * Date: 08/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

internal class SpannableCityDiffUtil(
    private val old: List<SpannableCity>,
    private val new: List<SpannableCity>
) : DiffUtil.Callback() {

    override fun getOldListSize() = old.size

    override fun getNewListSize() = new.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        old[oldItemPosition].city == new[newItemPosition].city

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        old[oldItemPosition].spannable == new[newItemPosition].spannable
}