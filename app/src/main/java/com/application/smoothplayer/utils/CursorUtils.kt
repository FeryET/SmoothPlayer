package com.application.smoothplayer.utils

import android.database.Cursor
import com.application.smoothplayer.factories.ProjectionProperties

fun Cursor.getData(
    key: ProjectionProperties,
    hashMap: HashMap<ProjectionProperties, String>
): String {
    return this.getString(this.getColumnIndex(hashMap[key]))
}