package com.sunny.usdpln.repository

import androidx.lifecycle.LiveData
import javax.inject.Singleton

@Singleton
interface MyRepository {

    fun fetchNewValueFromRemote(count: Int): LiveData<String>

    fun cancelFetchJob()

}