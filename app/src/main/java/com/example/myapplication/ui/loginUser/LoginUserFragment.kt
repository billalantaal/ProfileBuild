package com.example.myapplication.ui.loginUser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.example.myapplication.base.BaseFragment
import com.example.myapplication.business.User

class LoginUserFragment : BaseFragment(),LoginUserView {


    companion object {
        fun newInstance() = LoginUserFragment()
    }

    private lateinit var viewModel: LoginUserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_user_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginUserViewModel::class.java)
    }

    override fun onReceivedLoginUser(userdata: User) {
    }

    override fun OnError() {
    }

}
