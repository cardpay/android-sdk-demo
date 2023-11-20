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
import com.unlimint.sdk.ui.api.model.binding.Binding
import com.unlimint.sdk.ui.api.model.common.BankCardOrder
import com.unlimint.sdk.ui.api.model.common.Customer
import com.unlimint.sdk.ui.api.model.common.MerchantOrder
import com.unlimint.sdk.ui.api.model.common.PayPalOrder
import com.unlimint.sdk.ui.api.model.common.PaymentData
import com.unlimint.sdk.ui.api.model.common.TokenizedCardOrder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Currency
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
                        cardAccount = cardAccount,
                        type = Binding.Type.PAYMENT
                    ),
                    environment = Environments.SANDBOX,
                    showStatusScreen = true,        // optional
                    customizations = arrayListOf()  // optional
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
        cardAccount: ArrayList<TokenizedCardOrder.CardAccount>,
        launcher: ActivityResultLauncher<Intent>
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            val tokenizedBankCardData = TokenizedCardOrder(
                merchantName,
                customer,
                merchantOrder,
                paymentData,
                cardAccount
            )
            val bankCardData = BankCardOrder(
                merchantName,
                customer,
                merchantOrder,
                paymentData
            )
            val payPalPaymentMethodData = PayPalOrder(
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
                is Result.Success -> UnlimintSdk.paymentForResult(
                    activity = activity,
                    mobileAuthorizationToken = result.data,
                    launcher = launcher,
                    paymentMethodsData = paymentMethodsData,
                    environment = Environments.SANDBOX,
                    showStatusScreen = true,        // optional
                    showAmountOnButton = true,      // optional
                    customizations = arrayListOf()  // optional
                )

                is Result.Error -> _onPaymentError.postValue(result.exception.message)
            }
        }
    }
}