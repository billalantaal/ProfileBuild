package com.example.myapplication.ui.homeAuxliries.home

import com.example.myapplication.api.ApiManager
import com.example.myapplication.base.BaseViewModel
import com.example.myapplication.base.di.DaggerStrike
import javax.inject.Inject

class HomeViewModel : BaseViewModel<homeView>() {

    @Inject
    lateinit var apiManager: ApiManager

    init {
        DaggerStrike.doSimpleInjection().here(this)
    }
    fun getDataForms(){
        apiManager.getDataForForms {
            if(it==null){
                getUI().onError()
            }else{
                getUI().onReceivedHomeData(it)
            }
        }
    }



}
