package com.application.mvvmmusicplayer.di.viewmodel

import com.application.mvvmmusicplayer.di.application.AppComponent
import com.application.mvvmmusicplayer.ui.main.home.HomeFragment
import com.application.mvvmmusicplayer.ui.main.home.viewmodel.HomeViewModel
import com.application.mvvmmusicplayer.ui.main.home.viewmodel.HomeViewModelFactory
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelModule::class], dependencies = [AppComponent::class])
interface ViewModelComponent {
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun appComponent()

    }
    fun homeViewModelFactory(): HomeViewModelFactory
    fun homeViewModel(): HomeViewModel
    fun inject(homeFragment: HomeFragment)
}