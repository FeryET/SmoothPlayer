package com.application.mvvmmusicplayer.di.viewmodel

import dagger.MapKey
import java.lang.annotation.ElementType
import java.lang.annotation.RetentionPolicy
import androidx.lifecycle.ViewModel
import com.application.mvvmmusicplayer.di.scope.AppScope
import com.application.mvvmmusicplayer.repositories.SongsRepository
import com.application.mvvmmusicplayer.ui.main.home.viewmodel.HomeViewModel
import com.application.mvvmmusicplayer.ui.main.home.viewmodel.HomeViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import java.lang.annotation.ElementType.*
import java.lang.annotation.RetentionPolicy.*
import javax.inject.Provider
import kotlin.reflect.KClass

@Module
class ViewModelModule {

    @Target(
        AnnotationTarget.FUNCTION,
        AnnotationTarget.PROPERTY_GETTER,
        AnnotationTarget.PROPERTY_SETTER
    )
    @Retention(AnnotationRetention.RUNTIME)
    @MapKey
    internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

    @Provides
    fun providesHomeViewModelFactory(providerMap: Map<Class<out ViewModel>,
            @JvmSuppressWildcards Provider<ViewModel>>): HomeViewModelFactory {
        return HomeViewModelFactory(providerMap)
    }

    @IntoMap
    @Provides
    @ViewModelKey(HomeViewModel::class)
    fun providesHomeViewModel(songsRepository: SongsRepository): ViewModel{
        return HomeViewModel(songsRepository)
    }
}