package com.martin.kotlincleanarchitecture.models

import com.google.gson.annotations.SerializedName
import java.util.*

data class Graph(

    @SerializedName("rates")
    val rates: Map<String, ValueCurrency>


)