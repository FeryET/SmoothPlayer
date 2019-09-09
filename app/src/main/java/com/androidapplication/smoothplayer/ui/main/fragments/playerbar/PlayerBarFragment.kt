package com.androidapplication.smoothplayer.ui.main.fragments.playerbar

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import com.androidapplication.smoothplayer.ui.base.viewmodel.ViewModelFactory
import com.androidapplication.smoothplayer.ui.main.fragments.playerbar.viewmodel.PlayerBarViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PlayerBarFragment @Inject constructor() : DaggerFragment() {
    companion object{
        private const val TAG = "PlayerBarFragment"
    }

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