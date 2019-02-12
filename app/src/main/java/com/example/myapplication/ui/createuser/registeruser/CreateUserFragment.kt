package com.example.myapplication.ui.createuser.registeruser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.example.myapplication.base.BaseFragment
import com.example.myapplication.business.User
import com.example.myapplication.ui.createuser.registerviewmodel.CreateUserView
import com.example.myapplication.ui.createuser.registerviewmodel.CreateUserViewModel
import com.example.myapplication.ui.loginUser.LoginUserFragment
import com.example.myapplication.utils.AppConst
import com.example.myapplication.utils.UIAnimationUtils
import com.example.myapplication.utils.Utils
import kotlinx.android.synthetic.main.create_user_fragment.*


class CreateUserFragment : BaseFragment(), CreateUserView {


    companion object {
        fun newInstance() = CreateUserFragment()
    }

    private lateinit var viewModel: CreateUserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.create_user_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CreateUserViewModel::class.java)
        viewModel.attachUI(this)
//        getUserData()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSave.setOnClickListener {
            if (validationData()) {
                getUserData()
            }

        }
    }

    private fun getUserData() {
        if (Utils.isNetworkConnected(this.activity!!)) {
            showLoadingUI(true)
            showErrorUI("", false)
            viewModel.getRegisterUser(
                editTextFirstName.text.toString(),
                editTextLastName.text.toString(),
                editTextEmail.text.toString(),
                editTextPassword.text.toString(),
                editTextConfirmPass.text.toString()
            )
        } else {
            showErrorUI(AppConst.MSG_ERROR.NETWORK, true)
        }

    }

    private fun validationData(): Boolean {
        if ((editTextFirstName.text.isNotEmpty()) && (editTextFirstName.text.count() >= 4)) {
            if ((editTextLastName.text.isNotEmpty()) && (editTextLastName.text.count() >= 4)) {
                if ((editTextEmail.text.isNotEmpty()) && (editTextEmail.text.count() >= 4) && (editTextEmail.text.contains(
                        "@"
                    ))
                ) {
                    if ((editTextPassword.text.isNotEmpty()) && (editTextPassword.text.count() >= 4)) {
                        if ((editTextConfirmPass.text.isNotEmpty()) && editTextConfirmPass.text.toString().equals(editTextPassword.text.toString())) {
                            return true
                        } else {
                            Toast.makeText(this.context, "Password Not Match", Toast.LENGTH_LONG).show()
                            return false
                        }
                    } else {
                        Toast.makeText(this.context, "Oops Password TOO Short", Toast.LENGTH_LONG).show()
                        return false

                    }
                } else {
                    Toast.makeText(this.context, "Oops Email not Right", Toast.LENGTH_LONG).show()
                    return false

                }
            } else {
                Toast.makeText(this.context, "Oops Last Name TOO Short", Toast.LENGTH_LONG).show()
                return false

            }
        } else {
            Toast.makeText(this.context, "Oops FirstName TOO Short", Toast.LENGTH_LONG).show()
            return false

        }


    }

    private fun showLoadingUI(show: Boolean) {
        tvLoading.visibility = if (show) {
            UIAnimationUtils.applyFadeInFadeOut(tvLoading)
            View.VISIBLE
        } else {
            tvLoading.clearAnimation()
            View.GONE
        }
    }

    private fun showErrorUI(message: String, show: Boolean) {
        tvError.visibility = if (show) {
            tvError.text = message
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    override fun onUserDataReceived(usersData: User) {
//        Toast.makeText(activity, "Success 1", Toast.LENGTH_SHORT).show()
        showLoadingUI(false)
        showErrorUI("", false)

        if (usersData.IsSuccess!!) {
            nav_to_Login_User()
        }
    }

    private fun nav_to_Login_User() {
        val frg = LoginUserFragment()
        val fm = activity!!.supportFragmentManager
        val ft = fm.beginTransaction()
        ft.add(R.id.root_layout, frg, AppConst.FRGTAG.LoginUserFragment)
        ft.addToBackStack(AppConst.FRGTAG.CreateUserFragment)
        ft.hide(this)
        ft.commit()
    }

    override fun onUserReceived(user: User) {
        Toast.makeText(activity, "Success", Toast.LENGTH_SHORT).show()
    }

    override fun onError() {
        Toast.makeText(activity, "Opps Error", Toast.LENGTH_SHORT).show()
        showErrorUI(AppConst.MSG_ERROR.PREFIX, true)
    }

}
