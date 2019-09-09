package com.androidapplication.smoothplayer.ui.main.fragments.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.androidapplication.smoothplayer.R
import com.androidapplication.smoothplayer.models.SongModel
import com.androidapplication.smoothplayer.ui.base.musicinfoviews.BaseMusicInfoListAdapter

class SongListAdapter(context: Context) :
    BaseMusicInfoListAdapter<SongModel, MusicItemViewHolder>(context) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MusicItemViewHolder {
        return MusicItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.music_item_view_holder,
                parent,
                false
            ) as ViewGroup
        )
    }
}