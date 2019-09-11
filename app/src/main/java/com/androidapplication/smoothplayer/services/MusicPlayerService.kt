package com.androidapplication.smoothplayer.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import com.androidapplication.smoothplayer.player.PlayerController
import dagger.android.DaggerService
import javax.inject.Inject

enum class MusicPlayerCommands {
    PLAY, STOP, PAUSE, RESUME;

    companion object {
        fun mapToCommand(commandString: String?): MusicPlayerCommands? {
            return values().firstOrNull { it.name == commandString }
        }
    }
}

enum class MusicServiceDataFlags {
    SONG_MODEL
}

class MusicPlayerService @Inject constructor() : DaggerService() {

    inner class PlayerBinder(val service: MusicPlayerService) : Binder()

    private val binder: PlayerBinder = PlayerBinder(this)

    @Inject
    lateinit var playerController: PlayerController

    override fun onBind(intent: Intent?): IBinder? = binder

    override fun onStartCommand(
        intent: Intent?,
        flags: Int,
        startId: Int
    ): Int {
        intent?.apply {
            when (MusicPlayerCommands.mapToCommand(action)) {
                MusicPlayerCommands.PLAY -> {
                    playerController.playSong(
                        this.getParcelableExtra(
                            MusicServiceDataFlags.SONG_MODEL.name
                        )
                    )
                }
                MusicPlayerCommands.STOP -> {
                    playerController.stopCurrent()
                }
                MusicPlayerCommands.PAUSE -> {
                    playerController.pauseCurrent()
                }
                MusicPlayerCommands.RESUME -> {
                    playerController.resumeCurrent()
                }
                else -> stopSelf()
            }
        }
        return Service.START_STICKY
    }
}