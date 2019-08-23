package me.vponomarenko.tickets.app.common.ext

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Author: Valery Ponomarenko
 * Date: 11/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */
 
operator fun CompositeDisposable.plusAssign(d: Disposable) {
    add(d)
}