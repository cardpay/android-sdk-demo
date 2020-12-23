package com.unlimint

import android.app.Application
import com.unlimint.di.component.ApplicationComponent
import com.unlimint.di.component.DaggerApplicationComponent

class App : Application() {
    var appComponent: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerApplicationComponent.builder()
            .application(this)
            .build()
    }
}
