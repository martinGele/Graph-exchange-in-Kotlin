package com.martin.kotlincleanarchitecture.util

import io.reactivex.Scheduler
import io.reactivex.Single

class SchedulerProvider(val backgroundScheduler: Scheduler, val foregroundScheduler: Scheduler) {


    fun <T> getSchedulersForSingle(): (Single<T>) -> Single<T> {
        return { single: Single<T> ->
            single.subscribeOn(backgroundScheduler)
                .observeOn(foregroundScheduler)

        }
    }


}