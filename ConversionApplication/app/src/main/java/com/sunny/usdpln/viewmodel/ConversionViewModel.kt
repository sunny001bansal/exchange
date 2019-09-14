package com.sunny.usdpln.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sunny.usdpln.repository.MyRepository
import javax.inject.Inject

class ConversionViewModel @Inject constructor(
    private val mRepository: MyRepository
) : ViewModel() {

    //Needed a invoker to fetch data
    private val mTimerLive = MutableLiveData<Boolean>()
    private val mCount: MutableLiveData<Int> = MutableLiveData()
    private val mStatusViewLive = MutableLiveData<String>()
    private val mPlnValueLive = MutableLiveData<String>()
    //To observe and update status value on UI
    private val ratesLive: LiveData<String> = Transformations
        .switchMap(mCount) {
            mRepository.fetchNewValueFromRemote(it)
        }

    private var forOnce: Boolean = false

    fun getTimerLive() = mTimerLive
    fun getStatueViewLive() = mStatusViewLive
    fun getPLNValue() = mPlnValueLive

    fun fetchNewRates(count: Int) {
        mStatusViewLive.value = "Updating Exchange Rates...."
        mCount.value = count
        if (!forOnce)
            initInternalData()
    }

    fun onTimerTick(millisUntillFinish: Long) {
        val secLeft = millisUntillFinish / 1000
        mStatusViewLive.value = "Exchange rates will update in $secLeft second."
    }

    fun cancelFetchJob() {
        mRepository.cancelFetchJob()
    }

    private fun initInternalData() {
        forOnce = true
        ratesLive.observeForever (Observer { rate ->
            mPlnValueLive.value = rate
            mTimerLive.value = true
        })
    }

}