package com.example.myapplication.ui.homeAuxliries

import com.example.myapplication.ui.ProfileApp

interface homeView :ProfileApp {
    fun onReceivedHomeData()
    fun onError()
}