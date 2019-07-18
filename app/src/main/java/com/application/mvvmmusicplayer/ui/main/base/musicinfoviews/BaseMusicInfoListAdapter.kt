package com.application.mvvmmusicplayer.ui.main.base.musicinfoviews

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.mvvmmusicplayer.models.BaseInfoModel

abstract class BaseMusicInfoListAdapter<P : BaseInfoModel, T : BaseMusicInfoViewHolder>
    (protected val context: Context) : RecyclerView.Adapter<T>() {

    protected val dataList: ArrayList<P> = ArrayList()
    fun setData(array: ArrayList<P>) {
        dataList.clear()
        dataList.addAll(array)
    }

    fun resetData() {
        dataList.clear()
    }

    fun addData(item: P) {
        dataList.add(item)
    }
}