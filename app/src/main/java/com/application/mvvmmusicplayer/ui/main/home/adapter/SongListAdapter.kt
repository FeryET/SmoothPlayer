package com.application.mvvmmusicplayer.ui.main.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.application.mvvmmusicplayer.R
import com.application.mvvmmusicplayer.models.SongModel
import com.application.mvvmmusicplayer.ui.main.base.musicinfoviews.BaseMusicInfoListAdapter

class SongListAdapter(context: Context) : BaseMusicInfoListAdapter<SongModel, MusicItemViewHolder>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicItemViewHolder {
        return MusicItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.music_item_view_holder, parent, false) as ViewGroup
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MusicItemViewHolder, position: Int) {
        holder.bindData(context, dataList[position])
    }
}