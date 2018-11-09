package me.vponomarenko.tickets.app.common.ext

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * Author: Valery Ponomarenko
 * Date: 09/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

inline fun <reified T> LiveData<T>.observe(owner: LifecycleOwner, crossinline block: (T) -> Unit) {
    observe(owner, Observer { block(it) })
}