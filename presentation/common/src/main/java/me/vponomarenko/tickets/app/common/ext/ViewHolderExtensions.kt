package me.vponomarenko.tickets.app.common.ext

import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView

/**
 * Author: Valery Ponomarenko
 * Date: 10/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */
 
fun RecyclerView.ViewHolder.getString(@StringRes resId: Int) =
    itemView.context.getString(resId)

fun RecyclerView.ViewHolder.getString(@StringRes resId: Int, vararg args: Any) =
    itemView.context.getString(resId, *args)