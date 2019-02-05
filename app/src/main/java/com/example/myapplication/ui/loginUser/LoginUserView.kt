package com.example.myapplication.ui.loginUser

import com.example.myapplication.business.User
import com.example.myapplication.ui.ProfileApp

interface LoginUserView :ProfileApp {
    fun onReceivedLoginUser(userdata: User)
    fun OnError()
}