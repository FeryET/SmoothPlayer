package com.androidapplication.smoothplayer.di.service

import com.androidapplication.smoothplayer.services.MusicPlayerService
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ServiceBindingModule {
    @ContributesAndroidInjector
    abstract fun musicPlayerService(): MusicPlayerService
}