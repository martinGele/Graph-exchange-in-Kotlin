package com.martin.kotlincleanarchitecture.models

import com.google.gson.annotations.SerializedName
import java.util.*

data class Graph(
    @SerializedName("base")
    val base: String = "",
    @SerializedName("end_at")
    val endAt: String = "",
    @SerializedName("rates")
    val rates: Map<String, ValueCurrency>,
    @SerializedName("start_at")
    val startAt: String = ""


)