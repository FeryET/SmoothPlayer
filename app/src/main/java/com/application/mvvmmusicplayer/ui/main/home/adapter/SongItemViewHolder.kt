package com.application.mvvmmusicplayer.ui.main.home.adapter

import android.content.Context
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.application.mvvmmusicplayer.R
import com.application.mvvmmusicplayer.models.BaseInfoModel
import com.application.mvvmmusicplayer.models.SongModel
import com.application.mvvmmusicplayer.ui.main.base.musicinfoviews.BaseMusicInfoViewHolder
import com.bumptech.glide.Glide
import com.mikhaellopez.circularimageview.CircularImageView

private const val ALBUM_ART_SIZE_MULTIPLIER = 0.35f
class MusicItemViewHolder(viewGroup: ViewGroup) : BaseMusicInfoViewHolder(viewGroup) {


    @BindView(R.id.musicItemViewHolder_songNameTextView)
    lateinit var songNameTextView: TextView

    @BindView(R.id.musicItemViewHolder_artistNameTextView)
    lateinit var artistNameTextView: TextView

    @BindView(R.id.musicItemViewHolder_albumImageView)
    lateinit var albumArtImageView: CircularImageView

    init {
        ButterKnife.bind(viewGroup)
    }
    override fun bindData(context: Context, baseInfoModel: BaseInfoModel) {
        (baseInfoModel as SongModel).let { model ->
            artistNameTextView.text = model.ArtistName
            songNameTextView.text = model.songTitle
            Glide.with(context).load(model.ArtWorkLocation).
                placeholder(R.drawable.ic_music_note_black_24dp).
                thumbnail(ALBUM_ART_SIZE_MULTIPLIER).fitCenter().
                into(albumArtImageView)
        }
    }
}