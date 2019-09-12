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

    private val albumArtImageView: ImageView = viewGroup.view_holder_album_image_view
    private val artistNameTextView: TextView = viewGroup.view_holder_artist_name_text_view
    private val songNameTextView: TextView = viewGroup.view_holder_song_name_text_view

    override fun bindData(context: Context, baseInfoModel: BaseInfoModel) {
        with(baseInfoModel as SongModel) {
            artistNameTextView.text = artistName
            songNameTextView.text = songTitle
            Glide.with(context).load(artworkLocation)
                .placeholder(R.drawable.ic_music_note_black_24dp)
                .error(R.drawable.ic_music_note_black_24dp)
                .thumbnail(ALBUM_ART_SIZE_MULTIPLIER).fitCenter()
                .into(albumArtImageView)
        }
    }
}