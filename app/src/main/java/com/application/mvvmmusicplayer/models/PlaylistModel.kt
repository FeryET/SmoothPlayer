package com.application.mvvmmusicplayer.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PlaylistModel(@PrimaryKey var name: String, var songs: ArrayList<SongModel>, var artWorkLocation: String?){
    fun addSong(newSong: SongModel){
        songs.add(newSong)
    }
    fun removeSong(position: Int){
        songs.removeAt(position)
    }
}
