package com.example.myapplication.base.di.components

import com.example.myapplication.base.di.modules.ActivityModule
import com.example.myapplication.base.di.modules.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ActivityModule::class])
interface ActivityComponent : AppComponent