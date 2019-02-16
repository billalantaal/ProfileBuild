package com.example.myapplication.ui.profileAuxliries.registeruser

import com.example.myapplication.business.User
import com.example.myapplication.ui.ProfileApp

interface CreateUserView : ProfileApp {
    fun onUserDataReceived(usersData: User)
    fun onUserReceived(user: User)
    fun onError()
}