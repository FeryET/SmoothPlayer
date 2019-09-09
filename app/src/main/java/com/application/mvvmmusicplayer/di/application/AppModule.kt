package com.application.mvvmmusicplayer.di.application

import com.application.mvvmmusicplayer.base.MVVMMusicPlayerApplication
import com.application.mvvmmusicplayer.datamanagers.LibraryManager
import com.application.mvvmmusicplayer.repositories.SongsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
public class AppModule {

    @Provides
    @Singleton
    fun providesLibraryManager(application: MVVMMusicPlayerApplication): LibraryManager {
        return LibraryManager(application)
    }

    @Provides
    @Singleton
    fun providesSongRepository(libraryManager: LibraryManager): SongsRepository {
        return SongsRepository(libraryManager)
    }
}