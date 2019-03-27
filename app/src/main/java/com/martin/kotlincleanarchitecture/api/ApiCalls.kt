package com.martin.kotlincleanarchitecture.api

import com.martin.kotlincleanarchitecture.models.GraphModel
import io.reactivex.Single
import retrofit2.http.GET

interface ApiCalls {

    @GET("2018-02-22?access_key=eb29478c80bc50aa8184fe830d226b7f&base=EUR&symbols=USD,EUR")
    fun getCurenncyValue():Single<GraphModel>
}