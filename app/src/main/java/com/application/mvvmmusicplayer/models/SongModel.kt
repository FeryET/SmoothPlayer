package com.application.mvvmmusicplayer.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SongModel(
    @PrimaryKey val id: Int,
    val name: String,
    val Location: String,
    val ArtistName: String,
    val AlbumName: String,
    val ArtWorkLocation:String?)