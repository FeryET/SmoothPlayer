package com.application.mvvmmusicplayer.di.application

import com.application.mvvmmusicplayer.datamanagers.LibraryManager
import com.application.mvvmmusicplayer.repositories.SongsRepository
import com.application.mvvmmusicplayer.ui.main.MainActivity
import com.application.mvvmmusicplayer.ui.main.home.HomeFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun songRepository(): SongsRepository
    fun libraryManager(): LibraryManager
    fun inject(mainActivity: MainActivity)
    fun inject(homeFragment: HomeFragment)
}