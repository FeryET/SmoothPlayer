package com.androidapplication.smoothplayer.ui.main.fragments.playerbar

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import butterknife.ButterKnife
import com.androidapplication.smoothplayer.R
import com.androidapplication.smoothplayer.player.PlayerEntitiesProvider
import com.androidapplication.smoothplayer.ui.base.viewmodel.ViewModelFactory
import com.androidapplication.smoothplayer.ui.main.fragments.playerbar.viewmodel.PlayerBarViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import kotlinx.android.synthetic.main.player_bar_layout.*

class PlayerBarFragment @Inject constructor() : DaggerFragment() {
    companion object {
        private const val TAG = "PlayerBarFragment"
    }

    @Inject
    lateinit var playerEntitiesProvider: PlayerEntitiesProvider

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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater
            .inflate(R.layout.player_bar_layout, container, false)
            .also { view ->
                ButterKnife.bind(this, view)
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        player_bar_play_pause_current_song.setOnClickListener(object : View.OnClickListener{
            private var currentState = PlayState.READY_TO_PLAY
            override fun onClick(v: View?) {
                playerEntitiesProvider.player.playWhenReady = when(currentState){
                    PlayState.READY_TO_PAUSE -> false
                    PlayState.READY_TO_PLAY -> true
                }.also {result ->
                    currentState = if(result)
                        PlayState.READY_TO_PAUSE
                    else
                        PlayState.READY_TO_PLAY
                }
            }
        })
        player_bar_next_track.setOnClickListener{
            playNextTrack()
        }
        player_bar_previous_track.setOnClickListener{
            playPreviousTrack()
        }
        player_bar_stop.setOnClickListener {
            playerEntitiesProvider.player.stop()
        }
    }

    private fun playPreviousTrack() {}

    private fun playNextTrack() {}
}

private enum class PlayState {READY_TO_PLAY, READY_TO_PAUSE }
