package com.sunny.usdpln.repository.impl

import androidx.lifecycle.LiveData
import com.sunny.usdpln.network.APIService
import com.sunny.usdpln.repository.MyRepository

class MyRepositoryImpl(
    private val mApiService: APIService
) : MyRepository {

    override fun fetchNewValueFromRemote(): LiveData<String> = object : LiveData<String>(){}
}