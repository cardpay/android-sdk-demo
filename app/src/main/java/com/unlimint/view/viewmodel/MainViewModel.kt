package com.unlimint.view.viewmodel

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unlimint.data.Result
import com.unlimint.domain.Repository
import com.unlimint.sdk.api.MobileSdk
import com.unlimint.sdk.api.model.Customer
import com.unlimint.sdk.api.model.Environments
import com.unlimint.sdk.api.model.MerchantOrder
import com.unlimint.sdk.api.model.scenario.binding.Binding
import com.unlimint.sdk.api.model.scenario.payment.Payment
import com.unlimint.sdk.api.model.scenario.payment.PaymentData
import com.unlimint.sdk.api.model.scenario.payment.TokenPayment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _onBindCardError = MutableLiveData<String>()
    val onBindCardError: LiveData<String> = _onBindCardError

    fun bindCard(
        activity: AppCompatActivity,
        currency: Currency,
        customer: Customer,
        bindRequestCode: Int,
        merchantOrder: MerchantOrder?,
        cardAccount: Binding.CardAccount?
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getMobileToken()
            when (result) {
                is Result.Success -> MobileSdk.bindNewCardForResult(
                    activity = activity,
                    mobileAuthorizationToken = result.data,
                    requestCode = bindRequestCode,
                    bindingMethodData = Binding.Data(
                        currency = currency,
                        customer = customer,
                        merchantOrder = merchantOrder,
                        cardAccount = cardAccount
                    ),
                    environment = Environments.PRODUCTION
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
        cardAccount: Payment.CardAccount?,
        paymentRequestCode: Int
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getMobileToken()
            when (result) {
                is Result.Success -> MobileSdk.paymentForResult(
                    activity = activity,
                    mobileAuthorizationToken = result.data,
                    paymentMethodData = Payment.Data(
                        merchantName,
                        customer,
                        merchantOrder,
                        paymentData,
                        cardAccount
                    ),
                    requestCode = paymentRequestCode,
                    environment = Environments.PRODUCTION
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
        paymentRequestCode: Int
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getMobileToken()
            when (result) {
                is Result.Success -> MobileSdk.paymentForResult(
                    activity = activity,
                    mobileAuthorizationToken = result.data,
                    tokenPaymentMethodData = TokenPayment.Data(
                        merchantName,
                        customer,
                        merchantOrder,
                        paymentData,
                        cardAccount
                    ),
                    requestCode = paymentRequestCode,
                    environment = Environments.PRODUCTION
                )
                is Result.Error -> _onBindCardError.postValue(result.exception.message)
            }
        }
    }
}
