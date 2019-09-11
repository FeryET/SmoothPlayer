package com.androidapplication.smoothplayer.ui.main.fragments.playerbar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import butterknife.ButterKnife
import com.androidapplication.smoothplayer.R
import com.androidapplication.smoothplayer.models.SongModel
import com.androidapplication.smoothplayer.player.GlobalPlayerEventListener
import com.androidapplication.smoothplayer.player.PlayerEvent
import com.androidapplication.smoothplayer.player.PlayerEventListener
import com.androidapplication.smoothplayer.services.MusicPlayerCommands
import com.androidapplication.smoothplayer.services.MusicPlayerService
import com.androidapplication.smoothplayer.ui.base.viewmodel.ViewModelFactory
import com.androidapplication.smoothplayer.ui.main.fragments.playerbar.viewmodel.PlayerBarViewModel
import com.bumptech.glide.Glide
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.player_bar_layout.*
import javax.inject.Inject

class PlayerBarFragment @Inject constructor() : DaggerFragment(),
    PlayerEventListener {

    companion object {
        private const val TAG = "PlayerBarFragment"
    }

    @Inject
    lateinit var globalPlayerEventListener: GlobalPlayerEventListener
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: PlayerBarViewModel
    private var currentPlayButtonState: PlayButtonState =
        PlayButtonState.READY_TO_PLAY

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
        globalPlayerEventListener.addSubscriber(this)
        setupClickListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        globalPlayerEventListener.removeSubscriber(this)
    }

    private fun setupClickListeners() {
        player_bar_play_pause_current_song.setOnClickListener {
            val command = when (currentPlayButtonState) {
                PlayButtonState.READY_TO_PAUSE -> MusicPlayerCommands.PAUSE
                PlayButtonState.READY_TO_PLAY -> MusicPlayerCommands.RESUME
            }
            activity?.startService(
                Intent(context, MusicPlayerService::class.java).apply {
                    action = command.name
                }
            )
        }
        player_bar_stop.setOnClickListener {
            activity?.startService(Intent(context, MusicPlayerService::class.java).apply {
                action = MusicPlayerCommands.STOP.name
            })
        }
        //TODO: Fix these
//        player_bar_next_track.setOnClickListener {}
//        player_bar_previous_track.setOnClickListener {}
    }

    private fun playPreviousTrack() {
        TODO("playing mechanism is not yet handled.")
    }

    private fun playNextTrack() {
        TODO("playing mechanism is not yet handled.")
    }

    private fun PlayButtonState.updateView(): PlayButtonState {
        when (this) {
            PlayButtonState.READY_TO_PLAY -> {
                R.drawable.ic_play_arrow
            }
            PlayButtonState.READY_TO_PAUSE -> {
                R.drawable.ic_pause
            }
        }.also { drawable ->
            Glide.with(this@PlayerBarFragment).load(drawable)
                .into(player_bar_album_artwork)
        }
        return this
    }

    override fun onPlayerEvent(event: PlayerEvent, song: SongModel) {
        view?.visibility = View.VISIBLE
        if (event == PlayerEvent.PLAY_NEW_SONG) {
            Glide.with(this)
                .load(song.artworkLocation)
                .placeholder(R.drawable.ic_music_note_black_24dp)
                .error(R.drawable.ic_music_note_black_24dp)
                .into(player_bar_album_artwork)
        }
        when(event){
            PlayerEvent.PLAY_NEW_SONG -> PlayButtonState.READY_TO_PAUSE
            PlayerEvent.STOP_CURRENT, PlayerEvent.PAUSE_CURRENT -> PlayButtonState.READY_TO_PLAY
            else -> null
        }?.updateView()
    }
}


private enum class PlayButtonState(val stateFlag: Boolean) {
    READY_TO_PLAY(true), READY_TO_PAUSE(false);

    companion object {
        fun getStateOf(boolean: Boolean) =
            values().first { it.stateFlag == boolean }
    }
}
