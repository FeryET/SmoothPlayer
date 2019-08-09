package com.application.mvvmmusicplayer.base

import android.app.Application
import com.application.mvvmmusicplayer.di.application.AppComponent
import com.application.mvvmmusicplayer.di.application.AppModule
import com.application.mvvmmusicplayer.di.application.DaggerAppComponent

class MVVMMusicPlayerApplication: Application() {

    lateinit var appComponent: AppComponent
    private set
    override fun onCreate() {
        super.onCreate()
        appComponent =
            DaggerAppComponent
                .builder()
                .appModule(AppModule(this)).build()
    }


}