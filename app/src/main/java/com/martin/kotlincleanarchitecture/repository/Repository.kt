package com.martin.kotlincleanarchitecture.repository

import com.martin.kotlincleanarchitecture.api.ApiCalls
import com.martin.kotlincleanarchitecture.models.GraphModel
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val apiService: ApiCalls) {

    fun getDataFromApi(): Single<GraphModel> = apiService.getCurenncyValue()

}