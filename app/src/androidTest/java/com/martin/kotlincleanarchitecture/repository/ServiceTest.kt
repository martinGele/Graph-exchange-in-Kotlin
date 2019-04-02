package com.martin.kotlincleanarchitecture.repository

import android.provider.CallLog
import com.martin.kotlincleanarchitecture.api.ApiCalls
import com.martin.kotlincleanarchitecture.models.Graph
import com.martin.kotlincleanarchitecture.models.ValueCurrency
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.any
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class ServiceTest {


    val expectedResponses = listOf(
        ValueCurrency(1.0),
    ValueCurrency(2.0)
    )

    @Mock
    lateinit var service: ApiCalls

    @Before
    internal fun setUp() {
        MockitoAnnotations.initMocks(this)

    }

    @Test
    internal fun should_doSomethingWithRemoteDataFetchedWithCoroutines() {
        val actualRepos = runBlocking { service.currencyValue("a11n","as","asa").await() }

        actualRepos to  expectedResponses
    }
}