package com.application.mvvmmusicplayer.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

abstract class BaseInfoModel: Parcelable

@Parcelize
@Entity(tableName = "songs")
data class SongModel(
    @PrimaryKey val id: Int,
    val name: String,
    val Location: String,
    val ArtistName: String,
    val AlbumName: String,
    val ArtWorkLocation: String?
): BaseInfoModel()

@Parcelize
@Entity(tableName = "albums")
data class AlbumModel(@PrimaryKey val name: String,
                      val artistName: String,
                      var songList: ArrayList<SongModel>?): BaseInfoModel()

@Parcelize
@Entity(tableName = "artists")
data class ArtistModel(@PrimaryKey val Name: String,
                       var albumList: ArrayList<AlbumModel>?): BaseInfoModel()




