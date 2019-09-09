package com.androidapplication.smoothplayer.utils

import android.database.Cursor
import com.androidapplication.smoothplayer.factories.ProjectionProperties

fun Cursor.getData(
    key: ProjectionProperties,
    hashMap: HashMap<ProjectionProperties, String>
): String {
    return this.getString(this.getColumnIndex(hashMap[key]))
}