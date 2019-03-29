package com.martin.kotlincleanarchitecture.util

import com.anychart.chart.common.dataentry.ValueDataEntry

class CustomDataEntry internal constructor(x: String, value: Number, value2: Number, value3: Number) :
    ValueDataEntry(x, value) {

    init {
        setValue("value2", value2)
        setValue("value3", value3)
    }
}