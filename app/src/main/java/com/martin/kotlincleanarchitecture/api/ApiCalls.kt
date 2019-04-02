package com.martin.kotlincleanarchitecture.api

import com.martin.kotlincleanarchitecture.models.Graph
import io.reactivex.Single
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCalls {

    @GET("history?")
    fun currencyValue(@Query("start_at")start:String,
                      @Query("end_at")end:String, @Query("base")base: String):Deferred<Graph>
}