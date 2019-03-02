package com.example.myapplication

import android.app.Application
import android.content.Context
import com.example.myapplication.business.Field
import com.example.myapplication.business.Result

class SunCor : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: SunCor? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }

         var flha: List<Field> = emptyList()

    }

    override fun onCreate() {
        super.onCreate()
        // initialize for any

        // Use ApplicationContext.
        // example: SharedPreferences etc...
        val context: Context = SunCor.applicationContext()
    }

}