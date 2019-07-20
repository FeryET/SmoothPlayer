package com.application.mvvmmusicplayer.di.application

import android.app.Application
import com.application.mvvmmusicplayer.datamanagers.LibraryManager
import com.application.mvvmmusicplayer.repositories.SongsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
public class AppModule(val application: Application){

    @Provides @Singleton
    fun providesApplication(): Application{
        return application
    }

    @Provides @Singleton
    fun providesLibraryManager(): LibraryManager {
        return LibraryManager(application)
    }

    @Provides @Singleton
    fun providesSongRepository(libraryManager: LibraryManager): SongsRepository {
        return SongsRepository(libraryManager)
    }
}