package com.androidapplication.smoothplayer.player

import android.net.Uri
import com.androidapplication.smoothplayer.models.SongModel
import javax.inject.Inject

class PlayerController @Inject constructor(
    private val playerEntitiesProvider: PlayerEntitiesProvider,
    private val eventListener: GlobalPlayerEventListener
) {
    private lateinit var currentSong: SongModel
    fun playSong(song: SongModel) {
        with(playerEntitiesProvider) {
            player.prepare(
                mediaSourceFactory.createMediaSource(
                    Uri.parse(
                        song.location
                    )
                )
            )
            player.playWhenReady = true
        }
        currentSong = song
        eventListener.onPlayerEvent(PlayerEvent.PLAY_NEW_SONG, currentSong)
    }

    fun resumeCurrent() {
        playerEntitiesProvider.player.playWhenReady = true
        eventListener.onPlayerEvent(PlayerEvent.RESUME_CURRENT, currentSong)
    }

    fun pauseCurrent() {
        playerEntitiesProvider.player.playWhenReady = false
        eventListener.onPlayerEvent(PlayerEvent.PAUSE_CURRENT, currentSong)
    }

    fun stopCurrent() {
        playerEntitiesProvider.player.stop()
        eventListener.onPlayerEvent(PlayerEvent.STOP_CURRENT, currentSong)
    }
}



