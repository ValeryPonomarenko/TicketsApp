package me.vponomarenko.tickets.app.common.ext

import me.vponomarenko.tickets.app.common.renderer.ViewStateRenderer
import kotlin.reflect.KClass

/**
 * Author: Valery Ponomarenko
 * Date: 2019-04-17
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

fun <VS> ViewStateRenderer<VS>.toPair(): Pair<KClass<out ViewStateRenderer<VS>>, ViewStateRenderer<VS>> =
    this::class to this