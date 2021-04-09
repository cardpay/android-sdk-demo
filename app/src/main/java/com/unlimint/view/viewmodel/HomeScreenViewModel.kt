package com.unlimint.view.viewmodel

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import com.unlimint.data.Result
import com.unlimint.domain.Repository
import com.unlimint.sdk.api.MobileSdk
import com.unlimint.sdk.api.model.Customer
import com.unlimint.sdk.api.model.Environments
import com.unlimint.sdk.api.model.MerchantOrder
import com.unlimint.sdk.api.model.scenario.binding.Binding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

class HomeScreenViewModel @Inject constructor(
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
                    environment = Environments.SANDBOX
                )
                is Result.Error -> _onBindCardError.postValue(result.exception.message)
            }
        }
    }
}