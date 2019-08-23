package me.vponomarenko.tickets.app.common.renderer

import android.view.View

/**
 * Author: Valery Ponomarenko
 * Date: 31/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

interface ViewStateRenderer<VS> {
    fun render(view: View, viewState: VS)
}