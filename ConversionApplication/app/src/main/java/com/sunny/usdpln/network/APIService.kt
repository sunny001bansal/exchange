package com.sunny.usdpln.network

import com.sunny.usdpln.model.ExchageData
import retrofit2.http.GET

interface APIService {

    @GET("/latest")
    suspend fun fetchExchangeData(): ExchageData

}