package com.sunny.usdpln.viewmodel

import androidx.lifecycle.ViewModel
import com.sunny.usdpln.repository.MyRepository
import javax.inject.Inject

class ConversionViewModel @Inject constructor(
    private val mRepository: MyRepository
) : ViewModel() {

}