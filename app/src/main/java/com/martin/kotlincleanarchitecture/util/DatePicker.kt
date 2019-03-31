package com.martin.kotlincleanarchitecture.util

import android.app.DatePickerDialog
import android.content.Context
import java.util.*

var fromDateString: String = ""
var toDateString: String = ""
val c = Calendar.getInstance()!!

val year = c.get(Calendar.YEAR)
var month = c.get(Calendar.MONTH)
val day = c.get(Calendar.DAY_OF_MONTH)

fun clickDataPickerFrom(context: Context) {


    val datePickerDialog = DatePickerDialog(context, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

        month = monthOfYear + 1
        fromDateString = "$year-$month-$dayOfMonth"

    }, year, month, day)
    var datePicker = datePickerDialog.datePicker
    datePicker.maxDate = c.timeInMillis

    datePickerDialog.show()

}

fun clickDataPickerTo(context: Context) {

    val datePickerDialog = DatePickerDialog(context, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
        month = monthOfYear + 1
        toDateString = "$year-$month-$dayOfMonth"

    }, year, month, day)
    var datePicker = datePickerDialog.datePicker
    datePicker.maxDate = c.timeInMillis
    datePickerDialog.show()

}

fun checkForDatesOnString(): Boolean {

    return !fromDateString.isEmpty() && !toDateString.isEmpty()
}