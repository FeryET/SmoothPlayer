package com.androidapplication.smoothplayer.ui.main.fragments.home.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import com.androidapplication.smoothplayer.R
import com.androidapplication.smoothplayer.models.SongModel
import com.androidapplication.smoothplayer.player.PlayerEntitiesProvider
import com.androidapplication.smoothplayer.ui.base.musicinfoviews.BaseMusicInfoListAdapter

class SongListAdapter(
    context: Context,
    val playerEntitiesProvider: PlayerEntitiesProvider
) :
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
        ).apply {
            itemView.setOnClickListener {
                playMusic(adapterPosition)
            }
        }
    }

    private fun playMusic(adapterPosition: Int) {
        with(playerEntitiesProvider) {
            player.prepare(
                mediaSourceFactory.createMediaSource(
                    Uri.parse(dataList[adapterPosition].location)
                )
            )
            player.playWhenReady = true
        }
    }
}