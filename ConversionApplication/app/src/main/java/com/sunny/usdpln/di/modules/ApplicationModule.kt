package com.sunny.usdpln.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class ApplicationModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application
}