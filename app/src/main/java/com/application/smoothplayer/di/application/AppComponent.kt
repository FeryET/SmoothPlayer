package com.application.smoothplayer.di.application

import android.app.Application
import com.application.smoothplayer.base.MVVMMusicPlayerApplication
import com.application.smoothplayer.datamanagers.LibraryManager
import com.application.smoothplayer.di.activity.ActivityBindingModule
import com.application.smoothplayer.di.fragment.FragmentBindingModule
import com.application.smoothplayer.repositories.SongsRepository
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