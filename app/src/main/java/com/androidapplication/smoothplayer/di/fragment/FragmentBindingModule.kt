package com.androidapplication.smoothplayer.di.fragment

import com.androidapplication.smoothplayer.di.viewmodel.ViewModelModule
import com.androidapplication.smoothplayer.ui.main.fragments.home.HomeFragment
import com.androidapplication.smoothplayer.ui.main.fragments.playerbar.PlayerBarFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun homeFragment(): HomeFragment

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun playerBarFragment(): PlayerBarFragment
}