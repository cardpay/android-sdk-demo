package com.unlimint.di.component

import com.unlimint.di.module.ApplicationModule
import com.unlimint.di.scope.ApplicationScope
import com.unlimint.App
import com.unlimint.view.HomeScreenFragment
import dagger.BindsInstance
import dagger.Component

@Component(modules = [
    ApplicationModule::class
])

@ApplicationScope
interface ApplicationComponent {

    fun inject(homeScreenFragment: HomeScreenFragment)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder

        fun build(): ApplicationComponent
    }
}
