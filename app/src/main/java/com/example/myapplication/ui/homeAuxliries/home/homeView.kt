package com.example.myapplication.ui.homeAuxliries.home

import com.example.myapplication.business.Forms
import com.example.myapplication.ui.ProfileApp

interface homeView :ProfileApp {
    fun onReceivedHomeData(forms: Forms)
    fun onError()
}