package com.application.mvvmmusicplayer.utils

import android.database.Cursor

fun Cursor.getData(key: String, hashmap: HashMap<String, String>): String{
    return this.getString(this.getColumnIndex(hashmap[key]))
}