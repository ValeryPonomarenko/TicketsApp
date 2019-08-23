package me.vponomarenko.tickets.app.common.ext

import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import me.vponomarenko.tickets.app.common.renderer.Renderer

/**
 * Author: Valery Ponomarenko
 * Date: 09/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

inline fun <reified VS> LiveData<VS>.render(owner: LifecycleOwner, renderer: Renderer<VS>, view: View) {
    observe(owner, Observer { renderer.render(view, it) })
}