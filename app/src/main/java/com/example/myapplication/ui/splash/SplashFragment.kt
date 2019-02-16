package com.example.myapplication.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.base.BaseFragment
import com.example.myapplication.ui.homeAuxliries.HomeActivity
import com.example.myapplication.ui.profileAuxliries.loginUser.LoginUserFragment
import com.example.myapplication.utils.AppConst


class SplashFragment : BaseFragment() {


    companion object {
        fun newInstance() = SplashFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_splash, container, false)
        WaitTimeOut()
        return view
    }

    private fun WaitTimeOut() {
        Handler().postDelayed(Runnable {
 /*           if (AppConfig.getInstance().modelUser.isLoggedin()) {
                navToHomeActivity()
            } else {*/
                navToLoginFragment()
//            }
        }, 3000)
    }

    private fun navToLoginFragment() {
        try {
            val frg = LoginUserFragment()
            val fm = activity!!.supportFragmentManager
            val ft = fm.beginTransaction()
            ft.add(R.id.root_layout, frg, AppConst.FRGTAG.LoginUserFragment)
            ft.addToBackStack(AppConst.FRGTAG.CreateUserFragment)
            ft.hide(this)
            ft.commit()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }


    private fun navToHomeActivity() {
        val intent = Intent(activity, HomeActivity::class.java)
        startActivity(intent)
        activity!!.finish()
    }


}
