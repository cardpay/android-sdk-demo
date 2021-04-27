package com.unlimint.utils

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class ActivityResultLauncherProvider(activity: AppCompatActivity) {

    var activityResultListener: ActivityResultListener? = null

    val launcher: ActivityResultLauncher<Intent> =
        activity.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            activityResultListener?.onReceiveResult(it.resultCode, it.data)
        }
}

interface ActivityResultListener {
    fun onReceiveResult(resultCode: Int, data: Intent?)
}
