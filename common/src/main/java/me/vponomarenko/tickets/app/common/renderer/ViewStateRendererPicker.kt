package me.vponomarenko.tickets.app.common.renderer

import kotlin.reflect.KClass

/**
 * Author: Valery Ponomarenko
 * Date: 31/03/2019
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

interface ViewStateRendererPicker<VS> {
    fun pick(viewState: VS): KClass<out ViewStateRenderer<VS>>
}