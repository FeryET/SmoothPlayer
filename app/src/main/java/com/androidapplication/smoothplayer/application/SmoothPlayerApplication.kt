package com.androidapplication.smoothplayer.application

import android.annotation.SuppressLint
import android.content.Context
import com.androidapplication.smoothplayer.di.application.DaggerAppComponent
import com.androidapplication.smoothplayer.player.PlayerEntitiesProvider
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject

class SmoothPlayerApplication @Inject constructor() : DaggerApplication() {
    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    @Inject
    lateinit var playerEntitiesProvider: PlayerEntitiesProvider
    override fun onCreate() {
        super.onCreate()
        context = this
    }
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this).build()
    }
}