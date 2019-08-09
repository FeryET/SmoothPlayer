package com.application.mvvmmusicplayer.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.application.mvvmmusicplayer.datamanagers.LibraryManager
import com.application.mvvmmusicplayer.models.SongModel

class SongsRepository(private val libraryManager: LibraryManager) {
    private val mutableSongLibrary: MutableLiveData<ArrayList<SongModel>?> = MutableLiveData()
    val songLibrary: LiveData<ArrayList<SongModel>?> get() = mutableSongLibrary
    private fun updateSongLibrary(){
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