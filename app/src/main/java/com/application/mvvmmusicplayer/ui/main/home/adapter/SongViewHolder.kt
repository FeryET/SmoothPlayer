package com.application.mvvmmusicplayer.ui.main.home.adapter

import android.view.ViewGroup
import butterknife.ButterKnife
import com.application.mvvmmusicplayer.models.BaseInfoModel
import com.application.mvvmmusicplayer.ui.main.base.musicinfoviews.BaseMusicInfoViewHolder

class SongViewHolder(viewGroup: ViewGroup) : BaseMusicInfoViewHolder(viewGroup) {
    init {
        ButterKnife.bind(viewGroup)
    }
    override fun bindData(baseInfoModel: BaseInfoModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}