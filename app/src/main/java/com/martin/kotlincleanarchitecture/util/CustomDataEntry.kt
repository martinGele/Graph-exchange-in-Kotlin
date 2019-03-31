package com.martin.kotlincleanarchitecture.util

import com.anychart.chart.common.dataentry.ValueDataEntry

class CustomDataEntry internal constructor(x: String, value: Number) :
    ValueDataEntry(x, value) {

    init {
    }
}