package com.sunny.usdpln.di.providers

import com.sunny.usdpln.fragment.ConversionFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ConversionActivityProvider {

    @ContributesAndroidInjector
    abstract fun provideFirstFragment(): ConversionFragment

}