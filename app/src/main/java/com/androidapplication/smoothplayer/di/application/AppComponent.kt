package com.androidapplication.smoothplayer.di.application

import com.androidapplication.smoothplayer.application.SmoothPlayerApplication
import com.androidapplication.smoothplayer.datamanagers.LibraryManager
import com.androidapplication.smoothplayer.di.activity.ActivityBindingModule
import com.androidapplication.smoothplayer.di.fragment.FragmentBindingModule
import com.androidapplication.smoothplayer.di.service.ServiceBindingModule
import com.androidapplication.smoothplayer.player.GlobalPlayerEventListener
import com.androidapplication.smoothplayer.player.PlayerController
import com.androidapplication.smoothplayer.player.PlayerEntitiesProvider
import com.androidapplication.smoothplayer.repositories.SongsRepository
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBindingModule::class,
        FragmentBindingModule::class,
        ServiceBindingModule::class
    ]
)
interface AppComponent : AndroidInjector<SmoothPlayerApplication> {
    @Component.Factory
    interface Factory: AndroidInjector.Factory<SmoothPlayerApplication>
    fun songRepository(): SongsRepository
    fun libraryManager(): LibraryManager
    fun playerEntitiesProvider(): PlayerEntitiesProvider
    fun globalPlayerEventListener(): GlobalPlayerEventListener
    fun playerController(): PlayerController
}