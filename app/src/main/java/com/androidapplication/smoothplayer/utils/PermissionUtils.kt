package com.androidapplication.smoothplayer.utils

import android.app.Activity
import com.karumi.dexter.Dexter
import com.karumi.dexter.listener.single.PermissionListener


fun requestForASinglePermission(
    activity: Activity,
    permission: String,
    permissionListener: PermissionListener
) {
    Dexter.withActivity(activity)
        .withPermission(permission)
        .withListener(permissionListener)
        .check()
}
