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
import com.bumptech.glide.Glide
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
        player_bar_play_pause_current_song.setOnClickListener(object :
            View.OnClickListener {
            var currentState = PlayState.READY_TO_PLAY
            override fun onClick(v: View?) {
                with(playerEntitiesProvider.player){
                    currentState = PlayState.getStateOf(playWhenReady).init()
                    playWhenReady = currentState.stateFlag
                }
            }
        })

        player_bar_next_track.setOnClickListener {
            playNextTrack()
        }
        player_bar_previous_track.setOnClickListener {
            playPreviousTrack()
        }
        player_bar_stop.setOnClickListener {
            playerEntitiesProvider.player.stop()
        }
    }
    private fun playPreviousTrack() {
        TODO("playing mechanism is not yet handled.")
    }

    private fun playNextTrack() {
        TODO("playing mechanism is not yet handled.")
    }

    private fun PlayState.init(): PlayState {
        when(this){
            PlayState.READY_TO_PLAY -> {R.drawable.ic_play_arrow}
            PlayState.READY_TO_PAUSE -> {R.drawable.ic_pause}
        }.also {drawable ->
            Glide.with(this@PlayerBarFragment).load(drawable).into(player_bar_album_artwork)
        }
        return this
    }
}


private enum class PlayState(val stateFlag: Boolean) {
    READY_TO_PLAY(true), READY_TO_PAUSE(false);
    companion object{
        fun getStateOf(boolean: Boolean) = values().first{it.stateFlag == boolean}
    }
}
