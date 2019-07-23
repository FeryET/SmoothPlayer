package com.application.mvvmmusicplayer.di.viewmodel

import com.application.mvvmmusicplayer.di.application.AppComponent
import com.application.mvvmmusicplayer.di.application.AppModule
import com.application.mvvmmusicplayer.di.scope.AppScope
import com.application.mvvmmusicplayer.ui.main.home.HomeFragment
import com.application.mvvmmusicplayer.ui.main.home.viewmodel.HomeViewModel
import com.application.mvvmmusicplayer.ui.main.home.viewmodel.HomeViewModelFactory
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton

@AppScope
@Component(dependencies = [AppComponent::class], modules = [ViewModelModule::class])
interface ViewModelComponent {
    @Component.Builder
    interface Builder {
        fun appComponent(component: AppComponent): Builder
        fun build(): ViewModelComponent
    }
    fun appComponent(appModule: AppModule)
    fun homeViewModelFactory(): HomeViewModelFactory
    fun homeViewModel(): HomeViewModel
    fun inject(homeFragment: HomeFragment)
}