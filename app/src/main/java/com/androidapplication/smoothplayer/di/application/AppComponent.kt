package com.androidapplication.smoothplayer.di.application

import android.app.Application
import com.androidapplication.smoothplayer.application.SmoothPlayerApplication
import com.androidapplication.smoothplayer.datamanagers.LibraryManager
import com.androidapplication.smoothplayer.di.activity.ActivityBindingModule
import com.androidapplication.smoothplayer.di.fragment.FragmentBindingModule
import com.androidapplication.smoothplayer.player.PlayerEntitiesProvider
import com.androidapplication.smoothplayer.repositories.SongsRepository
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBindingModule::class,
        FragmentBindingModule::class
    ]
)
interface AppComponent : AndroidInjector<SmoothPlayerApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun create(app: Application): Builder

        fun build(): AppComponent
    }

    fun songRepository(): SongsRepository
    fun libraryManager(): LibraryManager
    fun playerEntitiesProvider(): PlayerEntitiesProvider
}