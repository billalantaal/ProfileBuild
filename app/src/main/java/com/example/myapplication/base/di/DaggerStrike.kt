package com.example.myapplication.base.di

import com.example.myapplication.base.di.components.ActivityComponent
import com.example.myapplication.base.di.components.AppComponent
import com.example.myapplication.base.di.components.NonAndroidComponent
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.base.di.modules.ActivityModule
import com.example.myapplication.base.di.modules.AppModule
import com.example.myapplication.base.di.modules.ObjectModule


object DaggerStrike {
    private var injector: AppComponent? = null
    private var simpleInjector: NonAndroidComponent? = null

    fun doAppComponentInjection(): AppComponent {

        if (injector == null || injector !is AppComponent) {
            injector = DaggerAppComponent.builder().appModule(AppModule()).build()
        }
        return injector!!
    }

    fun doActivityComponentInjection(baseActivity: BaseActivity): ActivityComponent {

        if (injector == null || injector !is ActivityComponent) {
            injector = DaggerActivityComponent.builder().activityModule(ActivityModule()).build()
        }
        return (injector as ActivityComponent)
    }


    fun doSimpleInjection(): NonAndroidComponent {
        if (simpleInjector == null)
            simpleInjector = DaggerNonAndroidComponent.builder().objectModule(ObjectModule()).build()
        return simpleInjector!!
    }


}
