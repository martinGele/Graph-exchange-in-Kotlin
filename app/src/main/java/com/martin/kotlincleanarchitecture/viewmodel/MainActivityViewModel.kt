package com.martin.kotlincleanarchitecture.viewmodel

import com.martin.kotlincleanarchitecture.models.Graph
import com.martin.kotlincleanarchitecture.repository.Repository
import com.martin.kotlincleanarchitecture.util.SchedulerProvider
import io.reactivex.Single


class MainActivityViewModel(private val repository: Repository, private val schedulerProvider: SchedulerProvider) {

    fun showDataFromApi(): Single<Graph> = repository.getDataFromApi()
        .compose(schedulerProvider.getSchedulersForSingle())
}