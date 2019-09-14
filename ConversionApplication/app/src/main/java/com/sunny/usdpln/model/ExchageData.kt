package com.sunny.usdpln.model

import com.google.gson.annotations.SerializedName

data class ExchageData(
    @SerializedName(value = "base")
    val base: String,
    @SerializedName(value = "date")
    val date: String,
    @SerializedName(value = "rates")
    val rates: Map<String, Float>
)