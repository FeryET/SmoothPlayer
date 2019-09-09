package com.application.smoothplayer.di.application

import android.app.Application
import com.application.smoothplayer.base.SmoothPlayerApplication
import com.application.smoothplayer.datamanagers.LibraryManager
import com.application.smoothplayer.player.PlayerEntitiesProvider
import com.application.smoothplayer.repositories.SongsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun providesLibraryManager(application: SmoothPlayerApplication): LibraryManager {
        return LibraryManager(application)
    }

    @Provides
    @Singleton
    fun providesSongRepository(libraryManager: LibraryManager): SongsRepository {
        return SongsRepository(libraryManager)
    }

    @Provides
    @Singleton
    fun providesPlayerEntitiesProvider(application: Application): PlayerEntitiesProvider {
        return PlayerEntitiesProvider(application)
    }
}