package com.application.mvvmmusicplayer.ui.main.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.mvvmmusicplayer.models.SongModel
import com.application.mvvmmusicplayer.repositories.SongsRepository
import javax.inject.Inject

class HomeViewModel(val context: Context): ViewModel() {
    @Inject
    lateinit var songsRepository: SongsRepository

    fun getSongs(): LiveData<List<SongModel>> {
        TODO()
    }
    private fun loadSongs(){

    }
    private val songs: MutableLiveData<List<SongModel>> by lazy {
        MutableLiveData<List<SongModel>>().also{
            loadSongs()
        }
    }
}