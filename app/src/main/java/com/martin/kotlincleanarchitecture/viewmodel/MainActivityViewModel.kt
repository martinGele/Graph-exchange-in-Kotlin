package com.martin.kotlincleanarchitecture.viewmodel

import com.martin.kotlincleanarchitecture.models.GraphModel
import com.martin.kotlincleanarchitecture.repository.Repository
import com.martin.kotlincleanarchitecture.util.SchedulerProvider
import io.reactivex.Single


class MainActivityViewModel(private val repository: Repository, private val schedulerProvider: SchedulerProvider) {

    fun showDataFromApi(): Single<GraphModel> = repository.getDataFromApi()
        .compose(schedulerProvider.getSchedulersForSingle())
}