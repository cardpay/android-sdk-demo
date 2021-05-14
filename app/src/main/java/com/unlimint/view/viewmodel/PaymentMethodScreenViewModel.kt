package com.unlimint.view.viewmodel

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unlimint.data.Result
import com.unlimint.domain.Repository
import com.unlimint.sdk.ui.api.UnlimintSdk
import com.unlimint.sdk.ui.api.model.Environments
import com.unlimint.sdk.ui.api.model.Payment
import com.unlimint.sdk.ui.api.model.TokenPayment
import com.unlimint.sdk.ui.api.model.info.Customer
import com.unlimint.sdk.ui.api.model.info.MerchantOrder
import com.unlimint.sdk.ui.api.model.payment.PaymentData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class PaymentMethodScreenViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _onBindCardError = MutableLiveData<String>()
    val onBindCardError: LiveData<String> = _onBindCardError

    fun pay(
        activity: AppCompatActivity,
        merchantName: String,
        customer: Customer,
        merchantOrder: MerchantOrder,
        paymentData: PaymentData,
        launcher: ActivityResultLauncher<Intent>
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getMobileToken()
            when (result) {
                is Result.Success -> UnlimintSdk.paymentForResult(
                    activity = activity,
                    mobileAuthorizationToken = result.data,
                    paymentMethodData = Payment.Data(
                        merchantName,
                        customer,
                        merchantOrder,
                        paymentData,
                        null
                    ),
                    launcher = launcher,
                    environment = Environments.SANDBOX
                )
                is Result.Error -> _onBindCardError.postValue(result.exception.message)
            }
        }
    }

    fun pay(
        activity: AppCompatActivity,
        merchantName: String,
        customer: Customer,
        merchantOrder: MerchantOrder,
        paymentData: PaymentData,
        cardAccount: TokenPayment.CardAccount,
        launcher: ActivityResultLauncher<Intent>
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getMobileToken()
            when (result) {
                is Result.Success -> UnlimintSdk.paymentForResult(
                    activity = activity,
                    mobileAuthorizationToken = result.data,
                    tokenPaymentMethodData = TokenPayment.Data(
                        merchantName,
                        customer,
                        merchantOrder,
                        paymentData,
                        cardAccount
                    ),
                    launcher = launcher,
                    environment = Environments.SANDBOX
                )
                is Result.Error -> _onBindCardError.postValue(result.exception.message)
            }
        }
    }

    fun payWithPayPal(
        activity: AppCompatActivity,
        merchantName: String,
        customer: Customer,
        merchantOrder: MerchantOrder,
        paymentData: PaymentData,
        launcher: ActivityResultLauncher<Intent>
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getMobileToken()
            when (result) {
                is Result.Success -> UnlimintSdk.paymentWithPayPalForResult(
                    activity = activity,
                    mobileAuthorizationToken = result.data,
                    paymentMethodData = Payment.PayPalData(
                        merchantName,
                        customer,
                        merchantOrder,
                        paymentData
                    ),
                    launcher = launcher,
                    environment = Environments.SANDBOX
                )
                is Result.Error -> _onBindCardError.postValue(result.exception.message)
            }
        }
    }
}
