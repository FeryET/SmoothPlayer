package com.application.smoothplayer.base

import android.annotation.SuppressLint
import android.content.Context
import com.application.smoothplayer.di.application.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject

class SmoothPlayerApplication @Inject constructor() : DaggerApplication() {
    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this).build()
    }
}