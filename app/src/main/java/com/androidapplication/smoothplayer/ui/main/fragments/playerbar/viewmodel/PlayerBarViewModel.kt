package com.androidapplication.smoothplayer.ui.main.fragments.playerbar.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.androidapplication.smoothplayer.models.SongModel

class PlayerBarViewModel : ViewModel(){
    private val currentSong: LiveData<SongModel> = MutableLiveData<SongModel>()
    private

    fun prepareSong(){}
}