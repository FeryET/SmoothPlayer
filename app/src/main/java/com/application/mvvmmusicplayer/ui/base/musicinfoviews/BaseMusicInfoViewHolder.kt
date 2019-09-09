package com.application.mvvmmusicplayer.ui.base.musicinfoviews

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.mvvmmusicplayer.models.BaseInfoModel

abstract class BaseMusicInfoViewHolder(viewGroup: ViewGroup) :
    RecyclerView.ViewHolder(viewGroup) {
    abstract fun bindData(context: Context, baseInfoModel: BaseInfoModel)
}