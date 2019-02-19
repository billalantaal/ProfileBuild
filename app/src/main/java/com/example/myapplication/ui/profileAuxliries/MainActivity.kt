package com.example.myapplication.ui.profileAuxliries

import android.os.Bundle
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.ui.profileAuxliries.loginUser.LoginUserFragment
import com.example.myapplication.ui.splash.SplashFragment
import com.crashlytics.android.Crashlytics;
import com.example.myapplication.R
import io.fabric.sdk.android.Fabric;


class MainActivity : BaseActivity() {

    override fun initViews() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fabric.with(this, Crashlytics())
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.root_layout, LoginUserFragment.newInstance(), "LoginUserFragment")
                .commit()
        }
    }
}
