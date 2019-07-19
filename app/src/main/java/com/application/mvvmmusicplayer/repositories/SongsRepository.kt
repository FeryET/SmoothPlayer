package com.application.mvvmmusicplayer.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.application.mvvmmusicplayer.datamanagers.LibraryManager
import com.application.mvvmmusicplayer.models.SongModel

class SongsRepository(private val libraryManager: LibraryManager) {
    fun getSongLibrary(): LiveData<ArrayList<SongModel>?>{
        val liveData =  MutableLiveData<ArrayList<SongModel>?>()
        liveData.value = libraryManager.songLibrary()
        return MutableLiveData<ArrayList<SongModel>?>().apply {
            value = libraryManager.songLibrary()
        }
    }


}