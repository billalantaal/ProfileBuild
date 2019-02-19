package com.example.myapplication.ui.homeAuxliries.flha

import com.example.myapplication.business.Forms
import com.example.myapplication.ui.ProfileApp

interface FLHAView : ProfileApp {

    fun onReceivedFLHA(forms: Forms)
    fun onError()
}