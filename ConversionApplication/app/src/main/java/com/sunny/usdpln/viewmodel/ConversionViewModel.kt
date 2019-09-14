package com.sunny.usdpln.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sunny.usdpln.repository.MyRepository
import javax.inject.Inject

class ConversionViewModel @Inject constructor(
    private val mRepository: MyRepository
) : ViewModel() {

    //Needed a invoker to fetch data
    private val mCount: MutableLiveData<Int> = MutableLiveData()

    private val mPlnValueLive: LiveData<String> = Transformations
        .switchMap(mCount) {
            mRepository.fetchNewValueFromRemote(it)
        }

    fun getPLNValue() = mPlnValueLive

    fun cancelFetchJob() {
        mRepository.cancelFetchJob()
    }

    fun fetchNewRates(count: Int) {
        mCount.value = count
    }


}