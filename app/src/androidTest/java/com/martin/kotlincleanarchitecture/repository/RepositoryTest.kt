package com.martin.kotlincleanarchitecture.repository

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.martin.kotlincleanarchitecture.api.ApiCalls
import com.martin.kotlincleanarchitecture.util.BASE_URL
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RepositoryTest {

    lateinit var service: ApiCalls

    @Before
    internal fun setUp() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(ApiCalls::class.java)
    }


    @Test
    internal fun should_callServiceWithCoroutine() {
        runBlocking {
            val repos = service.currencyValue("2019-3-3", "2019-4-2", "USD").await()

            repos.rates.entries.size

            repos.rates.entries
        }
    }


}