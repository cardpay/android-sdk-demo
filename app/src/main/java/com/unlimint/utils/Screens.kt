package com.unlimint.utils

import android.content.res.Resources
import android.util.DisplayMetrics

fun Float.px(): Float =
    this * (Resources.getSystem().displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)
