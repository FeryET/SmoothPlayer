package com.androidapplication.smoothplayer.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import dagger.android.DaggerService


class MusicPlayerService : DaggerService() {
    inner class PlayerBinder(val service: MusicPlayerService): Binder() {}
    private val binder: PlayerBinder = PlayerBinder(this)
    override fun onBind(intent: Intent?): IBinder? = binder
}