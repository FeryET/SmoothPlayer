package com.application.mvvmmusicplayer.di.viewmodel

import androidx.lifecycle.ViewModel
import com.application.mvvmmusicplayer.repositories.SongsRepository
import com.application.mvvmmusicplayer.ui.base.viewmodel.ViewModelFactory
import com.application.mvvmmusicplayer.ui.main.fragments.home.viewmodel.HomeViewModel
import com.application.mvvmmusicplayer.ui.main.fragments.playerbar.viewmodel.PlayerBarViewModel
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Provider
import kotlin.reflect.KClass

@Module
abstract class ViewModelModule {
    @Module
    companion object {
        @Target(
            AnnotationTarget.FUNCTION,
            AnnotationTarget.PROPERTY_GETTER,
            AnnotationTarget.PROPERTY_SETTER
        )
        @Retention(AnnotationRetention.RUNTIME)
        @MapKey
        internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

        @JvmStatic
        @Provides
        fun providesViewModelFactory(
            providerMap: Map<Class<out ViewModel>,
                    @JvmSuppressWildcards Provider<ViewModel>>
        ): ViewModelFactory {
            return ViewModelFactory(providerMap)
        }

        //<editor-fold desc="Home View Model Region">
        @IntoMap
        @Provides
        @JvmStatic
        @ViewModelKey(HomeViewModel::class)
        fun providesHomeViewModel(songsRepository: SongsRepository): ViewModel {
            return HomeViewModel(songsRepository)
        }
        //</editor-fold>

        //<editor-fold desc="PlayerBar View Model Region">
        @IntoMap
        @Provides
        @JvmStatic
        @ViewModelKey(PlayerBarViewModel::class)
        fun providesPlayerBarViewModel(songsRepository: SongsRepository): ViewModel {
            return PlayerBarViewModel()
        }
        //</editor-fold>
    }
}