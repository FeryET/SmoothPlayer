package com.application.mvvmmusicplayer.ui.main.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.mvvmmusicplayer.models.SongModel
import com.application.mvvmmusicplayer.repositories.SongsRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val songsRepository: SongsRepository): ViewModel() {
    val songs: LiveData<ArrayList<SongModel>?> = songsRepository.songLibrary
}