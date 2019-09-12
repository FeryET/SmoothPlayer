package com.androidapplication.smoothplayer.ui.main.fragments.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.androidapplication.smoothplayer.models.SongModel
import com.androidapplication.smoothplayer.repositories.SongsRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val songsRepository: SongsRepository) :
    ViewModel() {
    val songs: LiveData<ArrayList<SongModel>?> get() {
        return songsRepository.songLibrary
    }
}