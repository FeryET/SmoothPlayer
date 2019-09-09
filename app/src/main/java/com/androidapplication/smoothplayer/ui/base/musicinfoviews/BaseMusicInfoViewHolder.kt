package com.androidapplication.smoothplayer.ui.base.musicinfoviews

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidapplication.smoothplayer.models.BaseInfoModel

abstract class BaseMusicInfoViewHolder(viewGroup: ViewGroup) :
    RecyclerView.ViewHolder(viewGroup) {
    abstract fun bindData(context: Context, baseInfoModel: BaseInfoModel)
}