package com.unlimint.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.unlimint.sdk.R

object NavigationHelper {

    fun FragmentActivity.navigateTo(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack("")
            .commit()
    }
}