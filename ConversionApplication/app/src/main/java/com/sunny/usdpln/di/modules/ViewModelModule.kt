package com.sunny.usdpln.di.modules

import androidx.lifecycle.ViewModelProvider
import com.sunny.usdpln.di.provider.FragmentViewModelProvider
import com.sunny.usdpln.di.providerss.ActivityViewModelProvider
import com.sunny.usdpln.viewmodel.factory.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module(includes = [ActivityViewModelProvider::class, FragmentViewModelProvider::class])
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(mFactory: ViewModelFactory): ViewModelProvider.Factory
}

