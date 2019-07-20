package com.application.mvvmmusicplayer.ui.main.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.mvvmmusicplayer.models.SongModel
import com.application.mvvmmusicplayer.repositories.SongsRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val songsRepository: SongsRepository): ViewModel() {

    fun getSongs(): LiveData<ArrayList<SongModel>?> {
        return songs
    }

    private val songs: MutableLiveData<ArrayList<SongModel>> by lazy {
        MutableLiveData<ArrayList<SongModel>>().also{
            songsRepository.getSongLibrary()
        }
    }
}