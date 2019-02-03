package com.example.myapplication.base.di.components

import com.example.myapplication.api.ApiManager
import com.example.myapplication.base.di.modules.ObjectModule
import com.example.myapplication.ui.createuser.registerviewmodel.CreateUserViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ObjectModule::class])
interface NonAndroidComponent {
    fun here(apiManager: ApiManager)
    fun here(createUserModel: CreateUserViewModel)
}