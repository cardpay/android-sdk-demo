package com.unlimint.utils

import android.content.Context
import android.util.DisplayMetrics

fun convertDpToPx(dp: Float, context: Context): Float {
    return dp * (context.resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)
}
