package com.example.myapplication.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.ui.profileAuxliries.MainActivity

class SplashActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash)
    }

    override fun initViews() {
        waitTimeOut()
    }

    private fun waitTimeOut() {
        Handler().postDelayed(Runnable {
            /*           if (AppConfig.getInstance().modelUser.isLoggedin()) {
                           navToHomeActivity()
                       } else {*/
            navToMainActivity()
//            }
        }, 3000)
    }

    private fun navToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
