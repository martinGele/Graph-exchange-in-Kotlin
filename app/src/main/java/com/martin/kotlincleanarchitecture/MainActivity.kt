package com.martin.kotlincleanarchitecture

import android.os.Bundle
import android.util.Log
import com.google.gson.JsonParser
import com.martin.kotlincleanarchitecture.models.Graph
import com.martin.kotlincleanarchitecture.models.USD

import com.martin.kotlincleanarchitecture.viewmodel.MainActivityViewModel
import dagger.android.DaggerActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_main.view.*
import javax.inject.Inject
import org.json.JSONObject
import java.util.*
import kotlin.collections.HashMap


class MainActivity : DaggerActivity() {

    private val compositeDisposable by lazy { CompositeDisposable() }

    @Inject
    lateinit var mainActivityViewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        compositeDisposable.add(
            mainActivityViewModel.showDataFromApi()
                .subscribeBy(onSuccess = {

                    //                    Log.d("Print", it.rates.keys.toString())

                    val data = arrayOf<USD>()

                    it.rates.keys.contains("USD")


                    for (date in it.rates.keys) {
                        val value = it.rates[date]

                        





                    }

                }, onError = {
                    Log.d("MainActivity", it.message)


                })
        )


    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }
}
