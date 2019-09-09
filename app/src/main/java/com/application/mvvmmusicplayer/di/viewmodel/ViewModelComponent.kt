package com.application.mvvmmusicplayer.di.viewmodel

//
//import android.app.Application
//import androidx.fragment.app.Fragment
//import com.application.mvvmmusicplayer.di.application.AppComponent
//import com.application.mvvmmusicplayer.di.scope.AppScope
//import dagger.Component
//import dagger.android.AndroidInjector
//
//@AppScope
//@Component(dependencies = [AppComponent::class],
//    modules = [ViewModelModule::class])
//interface ViewModelComponent: AndroidInjector<Fragment> {
//    @Component.Builder
//    interface Builder {
//        fun app(application: Application): Builder
//        fun build(): ViewModelComponent
//    }
//}