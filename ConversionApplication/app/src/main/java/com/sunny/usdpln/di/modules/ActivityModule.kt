package com.sunny.usdpln.di.modules

import com.sunny.usdpln.activity.ConversionActivity
import com.sunny.usdpln.di.providers.ConversionActivityProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [ConversionActivityProvider::class])
    abstract fun bindConversionActivity(): ConversionActivity
}