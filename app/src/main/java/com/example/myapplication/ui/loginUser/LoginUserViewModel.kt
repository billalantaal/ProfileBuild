package com.example.myapplication.ui.loginUser

import androidx.lifecycle.ViewModel;
import com.example.myapplication.api.ApiManager
import com.example.myapplication.base.BaseViewModel
import javax.inject.Inject

class LoginUserViewModel : BaseViewModel<LoginUserView>() {
    @Inject
    lateinit var apiManager: ApiManager

    fun getLoginUser(){
        apiManager.postDataToLoginAPI {
            if (it==null){
                getUI().OnError()
            }else{
                getUI().onReceivedLoginUser(it)
            }
        }
    }
}
