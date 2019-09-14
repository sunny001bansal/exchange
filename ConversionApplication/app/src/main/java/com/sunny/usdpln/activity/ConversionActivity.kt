package com.sunny.usdpln.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.sunny.usdpln.R
import com.sunny.usdpln.fragment.ConversionFragment
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class ConversionActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.conversion_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ConversionFragment.newInstance())
                .commitNow()
        }
    }

}
