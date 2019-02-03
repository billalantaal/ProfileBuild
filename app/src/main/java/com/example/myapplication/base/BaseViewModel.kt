package com.example.myapplication.base

import androidx.lifecycle.ViewModel
import com.example.myapplication.ui.ProfileApp

abstract class BaseViewModel<UI : ProfileApp> : ViewModel() {

    private var appUI: UI? = null

    fun attachUI(ui: UI) {
        appUI = ui
    }

    override fun onCleared() {
        appUI = null
    }

    fun getUI() = appUI!!

}