package com.unlimint.di.module

import android.content.Context
import com.unlimint.di.scope.ApplicationScope
import com.unlimint.App
import dagger.Binds
import dagger.Module

@Module(
    includes = [
        AppModule::class,
        ViewModelModule::class
    ]
)
abstract class ApplicationModule {

    @Binds
    @ApplicationScope
    abstract fun bindApplicationContext(application: App): Context
}
