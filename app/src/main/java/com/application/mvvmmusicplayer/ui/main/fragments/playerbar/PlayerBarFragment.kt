package com.application.mvvmmusicplayer.ui.main.fragments.playerbar

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.application.mvvmmusicplayer.ui.base.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PlayerBarFragment @Inject constructor(): DaggerFragment() {
    private val TAG = this.javaClass.simpleName

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}