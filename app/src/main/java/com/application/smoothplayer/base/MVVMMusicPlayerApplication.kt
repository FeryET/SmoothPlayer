package com.application.smoothplayer.base

import com.application.smoothplayer.di.application.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject

class MVVMMusicPlayerApplication @Inject constructor() : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this).build()
    }
}