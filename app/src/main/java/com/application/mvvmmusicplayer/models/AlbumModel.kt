package com.application.mvvmmusicplayer.models

import androidx.room.PrimaryKey

data class AlbumModel(@PrimaryKey val name: String, val artistName: String, val songList: ArrayList<SongModel>)