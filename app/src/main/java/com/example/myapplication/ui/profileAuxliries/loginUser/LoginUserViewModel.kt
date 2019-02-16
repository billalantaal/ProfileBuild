package com.example.myapplication.ui.profileAuxliries.loginUser

import com.example.myapplication.api.ApiManager
import com.example.myapplication.base.BaseViewModel
import com.example.myapplication.base.di.DaggerStrike
import javax.inject.Inject

class LoginUserViewModel : BaseViewModel<LoginUserView>() {
    @Inject
    lateinit var apiManager: ApiManager

    init {
        DaggerStrike.doSimpleInjection().here(this)
//        getRegisterUser()
    }


    fun getLoginUser(userName:String,password:String){
        apiManager.postDataToLoginAPI(userName,password){
            if (it==null){
                getUI().OnError()
            }else{
                getUI().onReceivedLoginUser(it)
            }
        }
    }
}
