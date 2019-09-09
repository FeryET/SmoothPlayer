package com.application.mvvmmusicplayer.di.application

import android.app.Application
import com.application.mvvmmusicplayer.base.MVVMMusicPlayerApplication
import com.application.mvvmmusicplayer.datamanagers.LibraryManager
import com.application.mvvmmusicplayer.di.activity.ActivityBindingModule
import com.application.mvvmmusicplayer.di.fragment.FragmentBindingModule
import com.application.mvvmmusicplayer.repositories.SongsRepository
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
public interface AppComponent : AndroidInjector<MVVMMusicPlayerApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun create(app: Application): Builder

        fun build(): AppComponent
    }

    fun songRepository(): SongsRepository
    fun libraryManager(): LibraryManager
}