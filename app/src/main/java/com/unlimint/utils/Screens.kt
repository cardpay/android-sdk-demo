package com.unlimint.utils

import android.content.Context
import android.util.DisplayMetrics

fun Float.px(context: Context): Float {
    return this * (context.resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)
}
