package com.androidapplication.smoothplayer.player

import com.androidapplication.smoothplayer.models.SongModel

enum class PlayerEvent {
    PLAY_NEW_SONG, STOP_CURRENT, RESUME_CURRENT, PAUSE_CURRENT
}

interface PlayerEventListener{
    fun onPlayerEvent(event: PlayerEvent, song: SongModel)
}

class GlobalPlayerEventListener: PlayerEventListener {

    private val subscribers = ArrayList<PlayerEventListener>()

    override fun onPlayerEvent(event: PlayerEvent, song: SongModel) {
        for (listener in subscribers) {
            listener.onPlayerEvent(event,song)
        }
    }

    fun addSubscriber(listener: PlayerEventListener){
        subscribers.add(listener)
    }

    fun removeSubscriber(listener: PlayerEventListener){
        subscribers.remove(listener)
    }

}