package com.martin.kotlincleanarchitecture

import android.graphics.PorterDuff
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.View
import android.widget.Toast
import com.martin.kotlincleanarchitecture.util.checkForDatesOnString
import com.martin.kotlincleanarchitecture.util.clickDataPickerFrom
import com.martin.kotlincleanarchitecture.util.clickDataPickerTo
import com.martin.kotlincleanarchitecture.util.initGraph
import com.martin.kotlincleanarchitecture.viewmodel.MainActivityViewModel
import dagger.android.DaggerActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : DaggerActivity() {

    private val compositeDisposable by lazy { CompositeDisposable() }

    @Inject
    lateinit var mainActivityViewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()


    }

    private fun initView() {
        any_chart_view.setProgressBar(progressBar)
        progressBar.visibility = View.INVISIBLE
        fromButton.setOnClickListener { clickDataPickerFrom(this) }
        toButton.setOnClickListener { clickDataPickerTo(this) }

        search_button.setOnClickListener { makeApiCall() }


    }

    private fun makeApiCall() {

        if (checkForDatesOnString()) {
            progressBar.visibility = View.VISIBLE
            text_enter_search.visibility = View.INVISIBLE
            progressBar.indeterminateDrawable.setColorFilter(
                ContextCompat.getColor(this, R.color.colorAccent),
                PorterDuff.Mode.SRC_IN
            )
            if (checkForDatesOnString())
                compositeDisposable.add(
                    mainActivityViewModel.showDataFromApi()
                        .subscribeBy(onSuccess = {

                            val data = mutableListOf<HashMap<String, Any>>()

                            for (key in it.rates.keys) {
                                val value = it.rates.getValue(key).eUR

                                val date = it.rates[key]
                                val hashMap: HashMap<String, Any> = HashMap<String, Any>()
                                if (date != null) {
                                    hashMap["date"] = key
                                    hashMap["value"] = value

                                }
                                data.add(hashMap)
                            }


                            any_chart_view.setChart(initGraph(data))


                        }, onError = {
                            Log.d("MainActivity", it.message)


                        })
                )
        } else {
            val toast = Toast.makeText(applicationContext, R.string.no_dates_included, Toast.LENGTH_LONG)
            toast.show()
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }


}
