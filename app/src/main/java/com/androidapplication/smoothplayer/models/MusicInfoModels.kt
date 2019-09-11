package com.androidapplication.smoothplayer.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

abstract class BaseInfoModel : Parcelable

@Parcelize
@Entity(tableName = "songs")
data class SongModel(
    @PrimaryKey val id: Int,
    val songTitle: String,
    val location: String,
    val artistName: String,
    val albumName: String,
    val artWorkLocation: String?
) : BaseInfoModel()

@Parcelize
@Entity(tableName = "albums")
data class AlbumModel(
    @PrimaryKey val name: String,
    val artistName: String,
    val albumID: String,
    val albumArtPath: String,
    var songList: ArrayList<SongModel>?
) : BaseInfoModel()

@Parcelize
@Entity(tableName = "artists")
data class ArtistModel(
    @PrimaryKey val name: String,
    val artistID: String,
    var albumList: ArrayList<AlbumModel>?
) : BaseInfoModel()




