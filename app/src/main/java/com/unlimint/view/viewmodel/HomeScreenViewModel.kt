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
import com.unlimint.sdk.ui.api.model.*
import com.unlimint.sdk.ui.api.model.info.Customer
import com.unlimint.sdk.ui.api.model.info.MerchantOrder
import com.unlimint.sdk.ui.api.model.payment.PaymentData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

class HomeScreenViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _onBindCardError = MutableLiveData<String>()
    val onBindCardError: LiveData<String> = _onBindCardError

    private val _onPaymentError = MutableLiveData<String>()
    val onPaymentError: LiveData<String> = _onPaymentError

    fun bindCard(
        activity: AppCompatActivity,
        currency: Currency,
        customer: Customer,
        merchantOrder: MerchantOrder?,
        cardAccount: Binding.CardAccount?,
        launcher: ActivityResultLauncher<Intent>
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getMobileToken()
            when (result) {
                is Result.Success -> UnlimintSdk.bindNewCardForResult(
                    activity = activity,
                    mobileAuthorizationToken = result.data,
                    launcher = launcher,
                    bindingMethodData = Binding.Data(
                        currency = currency,
                        customer = customer,
                        merchantOrder = merchantOrder,
                        cardAccount = cardAccount
                    ),
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
        cardAccount: ArrayList<TokenizedBankCardData.CardAccount>,
        launcher: ActivityResultLauncher<Intent>
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            val tokenizedBankCardData = TokenizedBankCardData(
                merchantName,
                customer,
                merchantOrder,
                paymentData,
                cardAccount
            )
            val bankCardData = BankCardData(
                merchantName,
                customer,
                merchantOrder,
                paymentData
            )
            val payPalPaymentMethodData = PayPalData(
                merchantName,
                customer,
                merchantOrder,
                paymentData
            )

            val paymentMethodsData = arrayListOf(
                tokenizedBankCardData,
                bankCardData,
                payPalPaymentMethodData
            )

            val result = repository.getMobileToken()
            when (result) {
                is Result.Success -> UnlimintSdk.payForResult(
                    activity = activity,
                    mobileAuthorizationToken = result.data,
                    launcher = launcher,
                    paymentMethodsData = paymentMethodsData,
                    environment = Environments.SANDBOX
                )
                is Result.Error -> _onPaymentError.postValue(result.exception.message)
            }
        }
    }
}