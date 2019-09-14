package com.sunny.usdpln.di.provider

import androidx.lifecycle.ViewModel
import com.sunny.usdpln.viewmodel.ConversionViewModel
import com.sunny.usdpln.viewmodel.keymap.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FragmentViewModelProvider {
    @Binds
    @IntoMap
    @ViewModelKey(ConversionViewModel::class)
    abstract fun bindConversionViewModel(mViewModel: ConversionViewModel): ViewModel
}