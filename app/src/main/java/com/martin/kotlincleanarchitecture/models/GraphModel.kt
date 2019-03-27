package com.martin.kotlincleanarchitecture.models

import com.google.gson.annotations.SerializedName

data class GraphModel(
    @SerializedName("base")
    val base: String = "",
    @SerializedName("date")
    val date: String = "",
    @SerializedName("rates")
    val rates: Rates = Rates(),
    @SerializedName("success")
    val success: Boolean = false,
    @SerializedName("timestamp")
    val timestamp: Int = 0
)