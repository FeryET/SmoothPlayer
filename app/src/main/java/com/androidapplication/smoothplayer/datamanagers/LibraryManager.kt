package com.androidapplication.smoothplayer.datamanagers

import android.content.Context
import android.provider.MediaStore
import com.androidapplication.smoothplayer.factories.createLibrary
import com.androidapplication.smoothplayer.models.AlbumModel
import com.androidapplication.smoothplayer.models.ArtistModel
import com.androidapplication.smoothplayer.models.SongModel


@Suppress("UNCHECKED_CAST")
class LibraryManager(private val context: Context) {
    private val mediaStore = MediaStore()
    private val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI

    fun songLibrary(): ArrayList<SongModel>? {
        return createLibrary(
            context,
            SongModel::class.simpleName!!
        ) as? ArrayList<SongModel>
    }

    fun albumsLibrary(): ArrayList<AlbumModel>? {
        return createLibrary(
            context,
            AlbumModel::class.simpleName!!
        ) as? ArrayList<AlbumModel>
    }

    fun artistLibrary(): ArrayList<ArtistModel>? {
        return createLibrary(
            context,
            ArtistModel::class.simpleName!!
        ) as? ArrayList<ArtistModel>
    }
}


