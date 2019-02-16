package com.example.myapplication.ui.profileAuxliries.loginUser

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.example.myapplication.base.BaseFragment
import com.example.myapplication.business.User
import com.example.myapplication.ui.homeAuxliries.HomeActivity
import com.example.myapplication.ui.profileAuxliries.registeruser.CreateUserFragment
import com.example.myapplication.utils.AppConst
import kotlinx.android.synthetic.main.login_user_fragment.*

class LoginUserFragment : BaseFragment(),LoginUserView {



    companion object {
        fun newInstance() = LoginUserFragment()
    }

    private lateinit var viewModel: LoginUserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View= inflater.inflate(R.layout.login_user_fragment, container, false)
//        view.buttonSignUp.setOnClickListener { navtoRegisterUser() }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(LoginUserViewModel::class.java)
        viewModel.attachUI(this)

        buttonSignIn.setOnClickListener {
            viewModel.getLoginUser(et_username.text.toString(),et_password.text.toString())
        }
        buttonSignUp.setOnClickListener { navToRegisterUser() }
    }

    private fun navToRegisterUser() {
        val frg = CreateUserFragment()
        val fm = activity!!.supportFragmentManager
        val ft = fm.beginTransaction()
        ft.add(R.id.root_layout, frg, AppConst.FRGTAG.CreateUserFragment)
        ft.addToBackStack(AppConst.FRGTAG.LoginUserFragment)
        ft.hide(this)
        ft.commit()
    }

    private fun navToHomeActivity() {
        val intent = Intent(activity, HomeActivity::class.java)
        startActivity(intent)
        activity!!.finish()
    }

    override fun onReceivedLoginUser(userdata: User) {
        navToHomeActivity()
    }

    override fun OnError() {
        Toast.makeText(activity,"Error",Toast.LENGTH_LONG).show()
    }

}
