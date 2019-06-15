package com.application.mvvmmusicplayer.models

import androidx.room.PrimaryKey

data class ArtistModel(@PrimaryKey val Name: String, var albumList: ArrayList<AlbumModel>)