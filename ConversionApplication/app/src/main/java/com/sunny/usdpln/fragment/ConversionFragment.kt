package com.sunny.usdpln.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.sunny.usdpln.R
import com.sunny.usdpln.viewmodel.ConversionViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.conversion_frag.*
import javax.inject.Inject

class ConversionFragment : DaggerFragment() {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory


    private val mViewModel: ConversionViewModel by lazy {
        ViewModelProviders.of(this, mViewModelFactory).get(ConversionViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.conversion_frag, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

    override fun onDestroy() {
        mViewModel.cancelFetchJob()
        super.onDestroy()
    }

    private fun initObservers() {
        mViewModel.getPLNValue().observe(this@ConversionFragment, Observer { plnValue ->
            tv_pln_value.text = plnValue
        })

        mViewModel.fetchNewRates(0)
    }


    companion object {
        fun newInstance() = ConversionFragment()
    }
}
