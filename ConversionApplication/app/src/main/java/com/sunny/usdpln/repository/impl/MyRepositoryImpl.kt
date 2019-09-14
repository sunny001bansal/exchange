package com.sunny.usdpln.repository.impl

import androidx.lifecycle.LiveData
import com.sunny.usdpln.network.APIService
import com.sunny.usdpln.repository.MyRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MyRepositoryImpl(
    private val mApiService: APIService
) : MyRepository {

    private var fetchJob: CompletableJob? = null
    private val backgroundContext: CoroutineContext by lazy { Dispatchers.IO }
    private val foregroundContext: CoroutineContext by lazy { Dispatchers.Main }

    override fun fetchNewValueFromRemote(count: Int): LiveData<String> {
        fetchJob = Job()
        return object : LiveData<String>() {
            override fun onActive() {
                super.onActive()
                fetchJob?.let { theJob ->
                    CoroutineScope(backgroundContext + theJob).launch {
                        val user = mApiService.fetchExchangeData()
                        val rates = user.rates
                        var result: String
                        if (!rates.isNullOrEmpty()) {
                            val usd = rates[USD]
                            val pln = rates[PLN]
                            val convertedVal = convertUSDToPLN(usd!!, pln!!)
                            result = "$convertedVal"
                        } else {
                            result = "Map fetched is empty"
                        }
                        withContext(foregroundContext) {
                            value = result
                            theJob.complete()
                        }
                    }

                }

            }
        }
    }

    override fun cancelFetchJob() {
        fetchJob?.cancel()
    }


    private fun convertUSDToPLN(usd: Float, pln: Float) = pln / usd

    companion object {
        val USD = "USD"
        val PLN = "PLN"
    }
}