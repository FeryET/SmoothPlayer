package com.application.smoothplayer.ui.main.fragments.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.application.smoothplayer.models.SongModel
import com.application.smoothplayer.repositories.SongsRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val songsRepository: SongsRepository) :
    ViewModel() {
    val songs: LiveData<ArrayList<SongModel>?> = songsRepository.songLibrary
}