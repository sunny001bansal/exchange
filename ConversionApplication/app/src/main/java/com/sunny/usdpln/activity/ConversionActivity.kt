package com.sunny.usdpln.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sunny.usdpln.R
import com.sunny.usdpln.fragment.ConversionFragment

class ConversionActivity : AppCompatActivity() {

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
