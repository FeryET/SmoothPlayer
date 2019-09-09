package com.application.mvvmmusicplayer.factories

import android.content.Context
import android.database.Cursor
import android.provider.MediaStore
import com.application.mvvmmusicplayer.models.AlbumModel
import com.application.mvvmmusicplayer.models.ArtistModel
import com.application.mvvmmusicplayer.models.BaseInfoModel
import com.application.mvvmmusicplayer.models.SongModel
import com.application.mvvmmusicplayer.utils.getData


enum class ProjectionProperties {
    ID, ALBUM, ARTIST, ALBUM_ART, YEAR,
    NUM_OF_SONGS, NUM_OF_ALBUMS, NUM_OF_TRACKS,
    ALBUM_ID, ARTIST_ID, DATA, ARTIST_KEY,
    TITLE
}

private val ALBUM_SEARCH_PROJECTION = hashMapOf(
    ProjectionProperties.ID to MediaStore.Audio.Albums._ID,
    ProjectionProperties.ALBUM to MediaStore.Audio.Albums.ALBUM,
    ProjectionProperties.ARTIST to MediaStore.Audio.Albums.ARTIST,
    ProjectionProperties.ALBUM_ART to MediaStore.Audio.Albums.ALBUM_ART,
    ProjectionProperties.YEAR to MediaStore.Audio.Albums.FIRST_YEAR,
    ProjectionProperties.NUM_OF_SONGS to MediaStore.Audio.Albums.NUMBER_OF_SONGS
)

private val ARTIST_SEARCH_PROJECTION = hashMapOf(
    ProjectionProperties.ID to MediaStore.Audio.Artists._ID,
    ProjectionProperties.ARTIST to MediaStore.Audio.Artists.ARTIST,
    ProjectionProperties.ARTIST_KEY to MediaStore.Audio.Artists.ARTIST_KEY,
    ProjectionProperties.NUM_OF_ALBUMS to MediaStore.Audio.Artists.NUMBER_OF_ALBUMS,
    ProjectionProperties.NUM_OF_TRACKS to MediaStore.Audio.Artists.NUMBER_OF_TRACKS
)
private val SONG_SEARCH_PROJECTION = hashMapOf(
    ProjectionProperties.ID to MediaStore.Audio.AudioColumns._ID,
    ProjectionProperties.TITLE to MediaStore.Audio.AudioColumns.TITLE,
    ProjectionProperties.ALBUM to MediaStore.Audio.AudioColumns.ALBUM,
    ProjectionProperties.ALBUM_ID to MediaStore.Audio.AudioColumns.ALBUM_ID,
    ProjectionProperties.ARTIST to MediaStore.Audio.AudioColumns.ARTIST,
    ProjectionProperties.ARTIST_ID to MediaStore.Audio.AudioColumns.ARTIST_ID,
    ProjectionProperties.DATA to MediaStore.Audio.AudioColumns.DATA
)

private const val selection = MediaStore.Audio.Media.IS_MUSIC
private const val sortOrder = MediaStore.Audio.Media.TITLE + " ASC"

private val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI

fun createLibrary(
    context: Context,
    modelName: String
): ArrayList<BaseInfoModel>? {
    val cursor = context.contentResolver
        .query(
            uri, specificProjectionOfModelType(modelName),
            selection, null, sortOrder
        )
    cursor?.apply {
        val returnList = ArrayList<BaseInfoModel>()
        while (moveToNext()) {
            returnList.add(
                when (modelName) {
                    SongModel::class.simpleName -> {
                        cursor.createSongModel()
                    }
                    AlbumModel::class.simpleName -> {
                        cursor.createAlbumModel()
                    }
                    ArtistModel::class.simpleName -> {
                        cursor.createArtistModel()
                    }
                    else -> {
                        cursor.close()
                        throw IllegalArgumentException()
                    }
                }
            )
        }
        cursor.close()
        return returnList
    }
    return null
}

private fun specificProjectionOfModelType(modelName: String): Array<String> {
    return when (modelName) {
        SongModel::class.simpleName -> {
            SONG_SEARCH_PROJECTION.values.toTypedArray()
        }
        AlbumModel::class.simpleName -> {
            ALBUM_SEARCH_PROJECTION.values.toTypedArray()
        }
        ArtistModel::class.simpleName -> {
            ARTIST_SEARCH_PROJECTION.values.toTypedArray()
        }
        else -> throw IllegalArgumentException()
    }
}

private fun Cursor.createSongModel(): SongModel {
    SONG_SEARCH_PROJECTION.also { map ->
        return SongModel(
            getData(ProjectionProperties.ID, map).toInt(),
            getData(ProjectionProperties.TITLE, map),
            getData(ProjectionProperties.DATA, map),
            getData(ProjectionProperties.ARTIST, map),
            getData(ProjectionProperties.ALBUM, map),
            null
        )
    }
}

private fun Cursor.createAlbumModel(): AlbumModel {
    ALBUM_SEARCH_PROJECTION.also { map ->
        return AlbumModel(
            getData(ProjectionProperties.ALBUM, map),
            getData(ProjectionProperties.ARTIST, map),
            getData(ProjectionProperties.ALBUM_ID, map),
            getData(ProjectionProperties.ALBUM_ART, map),
            null
        )
    }
}

private fun Cursor.createArtistModel(): ArtistModel {
    ARTIST_SEARCH_PROJECTION.also { map ->
        return ArtistModel(
            getData(ProjectionProperties.ARTIST, map),
            getData(ProjectionProperties.ARTIST_ID, map),
            null
        )
    }
}