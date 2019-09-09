package com.application.smoothplayer.di.application

import com.application.smoothplayer.base.MVVMMusicPlayerApplication
import com.application.smoothplayer.datamanagers.LibraryManager
import com.application.smoothplayer.repositories.SongsRepository
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