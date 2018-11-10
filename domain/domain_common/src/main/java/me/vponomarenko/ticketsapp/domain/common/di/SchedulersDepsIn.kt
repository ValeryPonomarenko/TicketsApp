package me.vponomarenko.ticketsapp.domain.common.di

import io.reactivex.Scheduler

/**
 * Author: Valery Ponomarenko
 * Date: 11/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

interface SchedulersDepsIn {
    @IoScheduler
    fun provideIoScheduler(): Scheduler
    @UiScheduler
    fun provideUiScheduler(): Scheduler
}