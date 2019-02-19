package com.example.myapplication.ui.homeAuxliries.home

import com.example.myapplication.ui.ProfileApp

interface homeView :ProfileApp {
    fun onReceivedHomeData()
    fun onError()
}