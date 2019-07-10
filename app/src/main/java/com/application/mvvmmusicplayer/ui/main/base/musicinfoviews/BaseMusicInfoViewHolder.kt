package com.application.mvvmmusicplayer.ui.main.base.musicinfoviews

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.mvvmmusicplayer.models.BaseInfoModel

abstract class BaseMusicInfoViewHolder(viewGroup: ViewGroup): RecyclerView.ViewHolder(viewGroup){
    abstract fun bindData(baseInfoModel: BaseInfoModel)
}