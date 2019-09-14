package com.sunny.usdpln

import com.sunny.usdpln.di.DaggerMyApplicationComponent
import com.sunny.usdpln.di.MyApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class MyApplication : DaggerApplication() {

    companion object {
        lateinit var mAppComponent: MyApplicationComponent
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        mAppComponent = DaggerMyApplicationComponent
            .builder()
            .application(this)
            .build()
        return mAppComponent
    }
}