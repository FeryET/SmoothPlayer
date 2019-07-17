package com.application.mvvmmusicplayer.ui.main.home.adapter

import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.application.mvvmmusicplayer.R
import com.application.mvvmmusicplayer.models.BaseInfoModel
import com.application.mvvmmusicplayer.models.SongModel
import com.application.mvvmmusicplayer.ui.main.base.musicinfoviews.BaseMusicInfoViewHolder
import com.mikhaellopez.circularimageview.CircularImageView

class MusicItemViewHolder(viewGroup: ViewGroup) : BaseMusicInfoViewHolder(viewGroup) {

    @BindView(R.id.musicItemViewHolder_songNameTextView)
    lateinit var songNameTextView: TextView

    @BindView(R.id.musicItemViewHolder_artistNameTextView)
    lateinit var artistNameTextView: TextView

    @BindView(R.id.musicItemViewHolder_albumImageView)
    lateinit var albumArtImageView: CircularImageView

    @BindView(R.id.musicItemViewHolder_albumImageView_Placeholder)
    lateinit var albumArtPlaceHolder: ImageView

    init {
        ButterKnife.bind(viewGroup)
    }
    override fun bindData(baseInfoModel: BaseInfoModel) {
        (baseInfoModel as SongModel).let { model ->
            artistNameTextView.text = model.ArtistName
            songNameTextView.text = model.songTitle
            // TODO(Glide)
        }
    }
}