package com.example.myapplication.base.di.components

import android.content.Context
import com.example.myapplication.api.ApiManager
import com.example.myapplication.base.di.modules.ObjectModule
import com.example.myapplication.ui.homeAuxliries.flha.FLHAViewModel
import com.example.myapplication.ui.homeAuxliries.home.HomeViewModel
import com.example.myapplication.ui.profileAuxliries.loginUser.LoginUserViewModel
import com.example.myapplication.ui.profileAuxliries.registeruser.CreateUserViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ObjectModule::class])
interface NonAndroidComponent {
    fun here(apiManager: ApiManager)
    fun here(createUserModel: CreateUserViewModel)
    fun here(loginUserViewModel: LoginUserViewModel)
    fun here(flhaViewModel: FLHAViewModel)
    fun here(homeViewModel: HomeViewModel)
    fun here(context:Context)
}