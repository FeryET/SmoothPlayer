package com.application.smoothplayer.di.fragment

import com.application.smoothplayer.di.viewmodel.ViewModelModule
import com.application.smoothplayer.ui.main.fragments.home.HomeFragment
import com.application.smoothplayer.ui.main.fragments.playerbar.PlayerBarFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun homeFragment(): HomeFragment

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun playerBarFragment(): PlayerBarFragment
}