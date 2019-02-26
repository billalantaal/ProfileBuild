package com.example.myapplication.ui.homeAuxliries.flha

import com.example.myapplication.api.ApiManager
import com.example.myapplication.base.BaseViewModel
import com.example.myapplication.base.di.DaggerStrike
import javax.inject.Inject

class FLHAViewModel : BaseViewModel<FLHAView>() {

    @Inject
    lateinit var apiManager: ApiManager

    init {
        DaggerStrike.doSimpleInjection().here(this)
    }


}
