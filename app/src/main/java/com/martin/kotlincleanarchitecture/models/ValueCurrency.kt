package com.martin.kotlincleanarchitecture.models

import com.google.gson.annotations.SerializedName

data class ValueCurrency(

    @SerializedName("EUR")
    val eUR: Double = 0.0

)