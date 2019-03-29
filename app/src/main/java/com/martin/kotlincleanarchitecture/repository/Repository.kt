package com.martin.kotlincleanarchitecture.repository

import com.martin.kotlincleanarchitecture.api.ApiCalls
import com.martin.kotlincleanarchitecture.models.Graph
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val apiService: ApiCalls) {

    fun getDataFromApi(): Single<Graph> = apiService.curenncyValue("2011-08-01","2019-08-2","USD")

}