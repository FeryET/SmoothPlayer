package com.androidapplication.smoothplayer.di.application

import android.content.Context
import com.androidapplication.smoothplayer.application.SmoothPlayerApplication
import com.androidapplication.smoothplayer.datamanagers.LibraryManager
import com.androidapplication.smoothplayer.di.qualifiers.AppContext
import com.androidapplication.smoothplayer.player.GlobalPlayerEventListener
import com.androidapplication.smoothplayer.player.PlayerController
import com.androidapplication.smoothplayer.player.PlayerEntitiesProvider
import com.androidapplication.smoothplayer.repositories.SongsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Module(includes = [ContextModule::class])
class AppModule {
    @Module
    companion object {
        @JvmStatic
        @Provides
        @Singleton
        fun providesLibraryManager(@AppContext context: Context): LibraryManager {
            return LibraryManager(context)
        }

        @JvmStatic
        @Provides
        @Singleton
        fun providesSongRepository(libraryManager: LibraryManager): SongsRepository {
            return SongsRepository(libraryManager)
        }

        @JvmStatic
        @Provides
        @Singleton
        fun providesPlayerEntitiesProvider(@AppContext context: Context): PlayerEntitiesProvider {
            return PlayerEntitiesProvider(context)
        }

        @JvmStatic
        @Provides
        @Singleton
        fun providesGlobalPlayerEventListener(): GlobalPlayerEventListener {
            return GlobalPlayerEventListener()
        }

        @JvmStatic
        @Provides
        @Singleton
        fun providesPlayerController(
            playerEntitiesProvider: PlayerEntitiesProvider,
            globalPlayerEventListener: GlobalPlayerEventListener
        ): PlayerController {
            return PlayerController(
                playerEntitiesProvider,
                globalPlayerEventListener
            )
        }
    }
}

@Module(includes = [AndroidInjectionModule::class])
abstract class ContextModule {
    @Singleton
    @Binds
    @AppContext
    abstract fun bindContext(app: SmoothPlayerApplication): Context
}