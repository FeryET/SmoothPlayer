package com.application.smoothplayer.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "playlists")
@Parcelize
data class PlaylistModel(
    @PrimaryKey var name: String,
    var songs: ArrayList<SongModel>,
    var artWorkLocation: String?
) : BaseInfoModel() {
    fun addSong(newSong: SongModel) {
        songs.add(newSong)
    }

    fun removeSong(position: Int) {
        songs.removeAt(position)
    }
}