package com.unlimint.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.unlimint.di.scope.ApplicationScope
import com.unlimint.di.viewmodel.ViewModelFactory
import com.unlimint.di.viewmodel.ViewModelKey
import com.unlimint.view.viewmodel.HomeScreenViewModel
import com.unlimint.view.viewmodel.PaymentMethodScreenViewModel
import com.unlimint.view.viewmodel.PaymentWithTokenScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @ApplicationScope
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ApplicationScope
    @ViewModelKey(HomeScreenViewModel::class)
    abstract fun bindHomeScreenViewModel(viewModel: HomeScreenViewModel): ViewModel

    @Binds
    @IntoMap
    @ApplicationScope
    @ViewModelKey(PaymentMethodScreenViewModel::class)
    abstract fun bindPaymentMethodScreenViewModel(
        viewModel: PaymentMethodScreenViewModel
    ): ViewModel

    @Binds
    @IntoMap
    @ApplicationScope
    @ViewModelKey(PaymentWithTokenScreenViewModel::class)
    abstract fun bindPaymentWithTokenScreenViewModel(
        viewModel: PaymentWithTokenScreenViewModel
    ): ViewModel

}
