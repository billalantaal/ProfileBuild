package com.example.myapplication.ui.createuser.registerviewmodel

import com.example.myapplication.business.User
import com.example.myapplication.ui.ProfileApp

interface CreateUserView : ProfileApp {
    fun onCategoryDataReceived(usersData: List<User>)
    fun onCategoriesReceived(user: User)
    fun onError()
}