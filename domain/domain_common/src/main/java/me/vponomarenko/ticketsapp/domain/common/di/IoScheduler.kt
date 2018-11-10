package me.vponomarenko.ticketsapp.domain.common.di

import javax.inject.Qualifier



/**
 * Author: Valery Ponomarenko
 * Date: 11/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class IoScheduler(val value: String = "IoScheduler")
