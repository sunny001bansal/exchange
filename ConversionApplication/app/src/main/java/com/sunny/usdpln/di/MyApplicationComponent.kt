package com.sunny.usdpln.di

import android.app.Application
import android.content.Context
import com.sunny.usdpln.MyApplication
import com.sunny.usdpln.di.modules.ActivityModule
import com.sunny.usdpln.di.modules.ApplicationModule
import com.sunny.usdpln.di.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        ActivityModule::class,
        NetworkModule::class
    ]
)
interface MyApplicationComponent : AndroidInjector<MyApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): MyApplicationComponent
    }

    fun context(): Context
}