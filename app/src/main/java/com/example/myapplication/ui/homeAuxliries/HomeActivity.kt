package com.example.myapplication.ui.homeAuxliries

import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.ui.homeAuxliries.home.HomeFragment

class HomeActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment.newInstance())
                .commitNow()
        }
    }
    override fun initViews() {
    }

}
