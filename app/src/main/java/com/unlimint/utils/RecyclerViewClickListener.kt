package com.unlimint.utils

import android.os.SystemClock

class RecyclerViewClickListener<T>(
    private val defaultInterval: Int = 0,
    private val block: (item: T) -> Unit
) {
    private var lastTimeClicked: Long = 0

    fun onClicked(item: T) {
        if (defaultInterval == 0) {
            block(item)
        } else {
            if (SystemClock.elapsedRealtime() - lastTimeClicked < defaultInterval) {
                return
            }
            lastTimeClicked = SystemClock.elapsedRealtime()
            block(item)
        }
    }
}
