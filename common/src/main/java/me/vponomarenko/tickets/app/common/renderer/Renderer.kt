package me.vponomarenko.tickets.app.common.renderer

import android.view.View
import kotlin.reflect.KClass

/**
 * Author: Valery Ponomarenko
 * Date: 31/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class Renderer<VS>(
    private val viewStateRendererPicker: ViewStateRendererPicker<VS>,
    private val renderers: Map<KClass<out ViewStateRenderer<VS>>, ViewStateRenderer<VS>>
) {
    fun render(view: View, viewState: VS) {
        val rendererClass = viewStateRendererPicker.pick(viewState)
        renderers[rendererClass]?.render(view, viewState)
            ?: throw IllegalStateException("There is no ViewStateRenderer for ${rendererClass.simpleName}")
    }
}