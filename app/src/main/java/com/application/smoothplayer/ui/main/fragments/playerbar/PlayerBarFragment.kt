package com.application.smoothplayer.ui.main.fragments.playerbar

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import com.application.smoothplayer.ui.base.viewmodel.ViewModelFactory
import com.application.smoothplayer.ui.main.fragments.playerbar.viewmodel.PlayerBarViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PlayerBarFragment @Inject constructor() : DaggerFragment() {
    private val TAG = this.javaClass.simpleName

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: PlayerBarViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProviders.of(
            this,
            viewModelFactory
        )[PlayerBarViewModel::class.java]
    }
}