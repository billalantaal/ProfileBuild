package com.example.myapplication.ui.createuser.registerviewmodel

import com.example.myapplication.api.ApiManager
import com.example.myapplication.base.BaseViewModel
import com.example.myapplication.base.di.DaggerStrike
import javax.inject.Inject

class CreateUserViewModel : BaseViewModel<CreateUserView>() {

    @Inject
    lateinit var apiManager: ApiManager

    init {
        DaggerStrike.doSimpleInjection().here(this)
//        getRegisterUser()
    }

    fun getRegisterUser(){
        apiManager.postDataToRegisterAPI {
            if (it==null){
                getUI().onError()
            }else{
                getUI().onUserDataReceived(it)
            }
        }
    }

}
