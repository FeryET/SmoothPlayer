package com.application.mvvmmusicplayer.repositories

import android.content.Context
import android.database.Cursor
import android.provider.MediaStore
import com.application.mvvmmusicplayer.models.AlbumModel
import com.application.mvvmmusicplayer.models.SongModel
import com.application.mvvmmusicplayer.utils.getData

val ALBUM_SEARCH_PROJ = hashMapOf<String, String>(
    "id" to MediaStore.Audio.Albums._ID,
    "album" to MediaStore.Audio.Albums.ALBUM,
    "artist" to MediaStore.Audio.Albums.ARTIST,
    "album art" to MediaStore.Audio.Albums.ALBUM_ART,
    "year" to MediaStore.Audio.Albums.FIRST_YEAR,
    "num of songs" to MediaStore.Audio.Albums.NUMBER_OF_SONGS
)

val ARTIST_SEARCH_PROJ = hashMapOf<String, String>(
    "id" to MediaStore.Audio.Artists._ID,
    "artist" to MediaStore.Audio.Artists.ARTIST,
    "artist key" to MediaStore.Audio.Artists.ARTIST_KEY,
    "number of albums" to MediaStore.Audio.Artists.NUMBER_OF_ALBUMS,
    "number of tracks" to MediaStore.Audio.Artists.NUMBER_OF_TRACKS
)
val SONG_SEARCH_PROJ = hashMapOf<String, String>(
    "id" to MediaStore.Audio.AudioColumns._ID,
    "title" to MediaStore.Audio.AudioColumns.TITLE,
    "album" to MediaStore.Audio.AudioColumns.ALBUM,
    "album id" to MediaStore.Audio.AudioColumns.ALBUM_ID,
    "artist" to MediaStore.Audio.AudioColumns.ARTIST,
    "artist id" to MediaStore.Audio.AudioColumns.ARTIST_ID,
    "data" to MediaStore.Audio.AudioColumns.DATA
)
val selection = MediaStore.Audio.Media.IS_MUSIC
val sortOrder = MediaStore.Audio.Media.TITLE + " ASC"

class LibraryRepository(private val context: Context) {
    private val mediaStore = MediaStore()
    private val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI

    var songLibrary: () -> ArrayList<SongModel> = {
        var songsList = ArrayList<SongModel>()
        val cursor = context.contentResolver.query(
            uri,
            SONG_SEARCH_PROJ.values.toTypedArray(), selection, null, sortOrder
        )
        cursor?.let { current_cursor ->
            while (!current_cursor.isAfterLast) {
                SONG_SEARCH_PROJ.apply {
                    songsList.add(
                        SongModel(
                            current_cursor.getData("id", this).toInt(),
                            current_cursor.getData("title", this),
                            current_cursor.getData("data", this),
                            current_cursor.getData("artist", this),
                            current_cursor.getData("album", this),
                            null
                        )
                    )
                }
                current_cursor.moveToNext()
            }
            cursor.close()
        }
        songsList
    }

    var allAlbums: () -> ArrayList<AlbumModel> = {
        var albumList = ArrayList<AlbumModel>()
        var cursor = context.contentResolver.query(
            uri,
            ALBUM_SEARCH_PROJ.values.toTypedArray(), selection, null, sortOrder
        )
        cursor?.let {

        }

    }

    private fun <type> searchThroughMediaStore(projection: HashMap<String, String>): ArrayList<type> {
        var list = ArrayList<type>()
        var cursor = context.contentResolver.query(
            uri,
            projection.values.toTypedArray(), selection, null, sortOrder
        )
        cursor?.let { current_cursor ->
            while (!current_cursor.isAfterLast) {
                SONG_SEARCH_PROJ.apply {
                    list.add(
                        type(
                            cursor
                            null
                        )
                    )
                }
                current_cursor.moveToNext()
            }
            cursor.close()
        }
        songsList
    }

}


fun <Type> Cursor.lookForMediaData(projection: ArrayList<String>){
    var list = ArrayList<Type>()
    while (!this.isAfterLast) {
        SONG_SEARCH_PROJ.apply {
            list.add()
        }
        current_cursor.moveToNext()}
}

