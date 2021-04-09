package com.unlimint.utils

import android.os.SystemClock
import android.view.View

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

class SingleClickListener @JvmOverloads constructor(
    private val block: (View) -> Unit,
    private var defaultInterval: Int = 1000
) : View.OnClickListener {
    private var lastTimeClicked: Long = 0
    override fun onClick(v: View) {
        if (SystemClock.elapsedRealtime() - lastTimeClicked < defaultInterval) {
            return
        }
        lastTimeClicked = SystemClock.elapsedRealtime()
        block(v)
    }
}

fun View.setOnSingleClickListener(block: (View) -> Unit) {
    this.setOnClickListener(SingleClickListener(block))
}