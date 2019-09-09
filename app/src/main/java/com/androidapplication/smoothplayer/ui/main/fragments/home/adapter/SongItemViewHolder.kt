package com.androidapplication.smoothplayer.ui.main.fragments.home.adapter

import android.content.Context
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.androidapplication.smoothplayer.R
import com.androidapplication.smoothplayer.models.BaseInfoModel
import com.androidapplication.smoothplayer.models.SongModel
import com.androidapplication.smoothplayer.ui.base.musicinfoviews.BaseMusicInfoViewHolder
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.music_item_view_holder.view.*

private const val ALBUM_ART_SIZE_MULTIPLIER = 0.35f

class MusicItemViewHolder(viewGroup: ViewGroup) :
    BaseMusicInfoViewHolder(viewGroup) {

    private val albumArtImageView: ImageView = viewGroup.albumImageView
    private val artistNameTextView: TextView = viewGroup.artistNameTextView
    private val songNameTextView: TextView = viewGroup.songNameTextView

    override fun bindData(context: Context, baseInfoModel: BaseInfoModel) {
        (baseInfoModel as SongModel).let { model ->
            artistNameTextView.text = model.ArtistName
            songNameTextView.text = model.songTitle
            Glide.with(context).load(model.ArtWorkLocation)
                .placeholder(R.drawable.ic_music_note_black_24dp)
                .thumbnail(ALBUM_ART_SIZE_MULTIPLIER).fitCenter()
                .into(albumArtImageView)
        }
    }
}