package com.sunny.usdpln.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sunny.usdpln.R
import com.sunny.usdpln.viewmodel.ConversionViewModel

class ConversionFragment : Fragment() {

    companion object {
        fun newInstance() = ConversionFragment()
    }

    private lateinit var viewModel: ConversionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.conversion_frag, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ConversionViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
