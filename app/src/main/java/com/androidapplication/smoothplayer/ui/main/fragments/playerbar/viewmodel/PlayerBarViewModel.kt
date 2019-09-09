package com.androidapplication.smoothplayer.ui.main.fragments.playerbar.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.androidapplication.smoothplayer.models.SongModel
import com.androidapplication.smoothplayer.player.PlayerEntitiesProvider
import javax.inject.Inject

class PlayerBarViewModel : ViewModel() {
    @Inject
    private lateinit var playerEntitiesProvider: PlayerEntitiesProvider

    fun playNewSong(songModel: SongModel) {
        playerEntitiesProvider.apply {
            player.prepare(
                mediaSourceFactory.createMediaSource(Uri.parse(songModel.Location))
            )
            player.playWhenReady = true
        }
    }
    fun pausePlaying(){
        playerEntitiesProvider.player.playWhenReady = false
    }
    fun stopPlaying(){
        playerEntitiesProvider.player.stop(false)
    }
}