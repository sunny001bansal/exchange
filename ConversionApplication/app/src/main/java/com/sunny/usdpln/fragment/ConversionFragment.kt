package com.sunny.usdpln.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.sunny.usdpln.R
import com.sunny.usdpln.viewmodel.ConversionViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ConversionFragment : DaggerFragment() {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    companion object {
        fun newInstance() = ConversionFragment()
    }

    private val mViewModel: ConversionViewModel by lazy {
        ViewModelProviders.of(this, mViewModelFactory).get(ConversionViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.conversion_frag, container, false)
    }
}
