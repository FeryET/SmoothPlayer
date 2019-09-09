package com.androidapplication.smoothplayer.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.androidapplication.smoothplayer.datamanagers.LibraryManager
import com.androidapplication.smoothplayer.models.SongModel

class SongsRepository(private val libraryManager: LibraryManager) {
    private val mutableSongLibrary: MutableLiveData<ArrayList<SongModel>?> =
        MutableLiveData()
    val songLibrary: LiveData<ArrayList<SongModel>?> get() = mutableSongLibrary
    private fun updateSongLibrary() {
        mutableSongLibrary.postValue(libraryManager.songLibrary())
    }

    init {
        updateSongLibrary()
    }
//    fun getSongLibrary(): LiveData<ArrayList<SongModel>?>{
//        return MutableLiveData<ArrayList<SongModel>?>().apply {
//            value = libraryManager.songLibrary()
//        }
//    }


}