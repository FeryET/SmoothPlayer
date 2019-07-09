package com.application.mvvmmusicplayer.repositories

import android.content.Context
import android.database.Cursor
import android.provider.MediaStore
import com.application.mvvmmusicplayer.factories.createLibrary
import com.application.mvvmmusicplayer.models.AlbumModel
import com.application.mvvmmusicplayer.models.ArtistModel
import com.application.mvvmmusicplayer.models.SongModel
import com.application.mvvmmusicplayer.utils.getData


class LibraryManager(private val context: Context) {
    private val mediaStore = MediaStore()
    private val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI

    var songLibrary: () -> ArrayList<SongModel>? = {
        createLibrary(context,SongModel::class.simpleName!!) as? ArrayList<SongModel>
    }

    var albumsLibrary: () -> ArrayList<AlbumModel>? = {
        createLibrary(context, AlbumModel::class.simpleName!!) as? ArrayList<AlbumModel>
    }

    var artistLibrary: () -> ArrayList<ArtistModel>? = {
        createLibrary(context, ArtistModel::class.simpleName!!) as? ArrayList<ArtistModel>
    }
}


