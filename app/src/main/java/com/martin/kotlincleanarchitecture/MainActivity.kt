package com.martin.kotlincleanarchitecture

import android.graphics.PorterDuff
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.Toast
import com.martin.kotlincleanarchitecture.util.checkForDatesOnString
import com.martin.kotlincleanarchitecture.util.clickDataPickerFrom
import com.martin.kotlincleanarchitecture.util.clickDataPickerTo
import com.martin.kotlincleanarchitecture.util.initGraph
import com.martin.kotlincleanarchitecture.viewmodel.MainActivityViewModel
import dagger.android.DaggerActivity
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
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
        val data = mutableListOf<HashMap<String, Any>>()

        if (checkForDatesOnString()) {
            progressBar.visibility = View.VISIBLE
            text_enter_search.visibility = View.INVISIBLE
            progressBar.indeterminateDrawable.setColorFilter(
                ContextCompat.getColor(this, R.color.colorAccent),
                PorterDuff.Mode.SRC_IN
            )

            GlobalScope.launch(Dispatchers.Main) {
                val getCall = mainActivityViewModel.showDataFromApi()


                //TODO this should be changed to reponse if success or not

                try {


                    for (key in getCall.rates.keys) {
                        val value = getCall.rates.getValue(key).eUR

                        val date = getCall.rates[key]
                        val hashMap: HashMap<String, Any> = HashMap<String, Any>()
                        if (date != null) {
                            hashMap["date"] = key
                            hashMap["value"] = value

                        }
                        data.add(hashMap)
                    }
                    any_chart_view.setChart(initGraph(data))


                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }


        } else {
            val toast = Toast.makeText(applicationContext, R.string.no_dates_included, Toast.LENGTH_LONG)
            toast.show()
        }


    }


}
