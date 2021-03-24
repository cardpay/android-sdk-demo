package com.unlimint.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.unlimint.App
import com.unlimint.R
import com.unlimint.sdk.api.MobileSdk
import com.unlimint.sdk.api.exceptions.*
import com.unlimint.sdk.api.model.Customer
import com.unlimint.sdk.api.model.MerchantOrder
import com.unlimint.sdk.api.model.scenario.payment.Amount
import com.unlimint.sdk.api.model.scenario.payment.PaymentData
import com.unlimint.sdk.api.model.scenario.payment.TokenPayment
import com.unlimint.view.viewmodel.MainViewModel
import java.math.BigDecimal
import java.util.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    private val boundCardPanTextView by lazy { findViewById<TextView>(R.id.bound_card_pan) }
    private val paidCardPanTextView by lazy { findViewById<TextView>(R.id.paid_card_pan) }
    private val bindButton by lazy { findViewById<Button>(R.id.bind_button) }
    private val paymentButton by lazy { findViewById<Button>(R.id.pay_button) }
    private val paymentWithTokenButton by lazy { findViewById<Button>(R.id.pay_with_token_button) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as App).appComponent?.inject(this)

        bindButton.setOnClickListener {
            startService(TransactionService.getNewIntent(this))
            onBindButtonClick()
        }

        paymentButton.setOnClickListener {
            startService(TransactionService.getNewIntent(this))
            onPaymentButtonClick()
        }

        paymentWithTokenButton.setOnClickListener {
            startService(TransactionService.getNewIntent(this))
            onPaymentWithTokenButtonClick()
        }

        subscribeUi()
    }

    private fun subscribeUi() {
        viewModel.onBindCardError.observe(this, { errorText ->
            Toast.makeText(this, errorText, Toast.LENGTH_LONG).show()
        })
    }

    private fun onBindButtonClick() {
        viewModel.bindCard(
            activity = this,
            currency = Currency.getInstance("USD"),
            customer = Customer(
                id = "656945944",
                email = "cardpay.test.mobile@gmail.com"
            ),
            bindRequestCode = BIND_REQUEST_CODE,
            cardAccount = null,
            merchantOrder = null
        )
    }

    private fun onPaymentButtonClick() {
        viewModel.pay(
            activity = this,
            merchantName = "merchantName",
            customer = Customer(
                id = "656945944",
                email = "cardpay.test.mobile@gmail.com"
            ),
            merchantOrder = MerchantOrder(
                description = "merchant order description",
                id = "merchant order id"
            ),
            paymentData = PaymentData(
                amount = Amount(
                    value = BigDecimal.valueOf(1.0),
                    currency = Currency.getInstance("USD")
                )
            ),
            cardAccount = null,
            paymentRequestCode = PAY_REQUEST_CODE
        )
    }

    private fun onPaymentWithTokenButtonClick() {
        viewModel.pay(
            activity = this,
            merchantName = "merchantName",
            customer = Customer(
                id = "656945944",
                email = "cardpay.test.mobile@gmail.com"
            ),
            merchantOrder = MerchantOrder(
                description = "merchant order description",
                id = "merchant order id"
            ),
            paymentData = PaymentData(
                amount = Amount(
                    value = BigDecimal.valueOf(1.0),
                    currency = Currency.getInstance("USD")
                )
            ),
            cardAccount = TokenPayment.CardAccount(
                tokenData = TokenPayment.TokenData(
                    token = "token_from_already_saved_card",
                    last4PanDigits = "1234"
                )
            ),
            paymentRequestCode = PAY_REQUEST_CODE
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            BIND_REQUEST_CODE -> handleBinding(resultCode, data)
            PAY_REQUEST_CODE -> handlePayment(resultCode, data)
        }
    }

    private fun handleBinding(resultCode: Int, data: Intent?) {
        when (resultCode) {
            Activity.RESULT_OK -> {
                data?.getStringExtra(MobileSdk.ARG_LAST_4_DIGITS)?.let {
                    boundCardPanTextView.visibility = View.VISIBLE
                    boundCardPanTextView.text = getString(R.string.card_masked_pan, it)
                }
            }
            Activity.RESULT_CANCELED -> data?.getSerializableExtra(MobileSdk.ARG_EXCEPTION)
                ?.let {
                    when (it) {
                        is MobileSdkServiceUnavailableException -> toast("Server error")
                        is MobileSdkIllegalStateException -> toast("Internal error")
                        is MobileSdkBindingDeclineException -> toast("Failed binding")
                        is MobileSdkSecurityException -> toast(it.message!!)
                        is MobileSdkUnauthorizedException -> toast(it.message!!)
                    }
                }
        }
    }

    private fun handlePayment(resultCode: Int, data: Intent?) {
        when (resultCode) {
            Activity.RESULT_OK -> {
                data?.getStringExtra(MobileSdk.ARG_LAST_4_DIGITS)
                    ?.let {
                        paidCardPanTextView.visibility = View.VISIBLE
                        paidCardPanTextView.text = getString(R.string.card_masked_pan, it)
                    }
                    ?: run {
                        paidCardPanTextView.visibility = View.GONE
                        paidCardPanTextView.text = ""
                    }
            }
            Activity.RESULT_CANCELED -> data?.getSerializableExtra(MobileSdk.ARG_EXCEPTION)
                ?.let {
                    when (it) {
                        is MobileSdkServiceUnavailableException -> toast("Server error")
                        is MobileSdkIllegalStateException -> toast("Internal error")
                        is MobileSdkBindingDeclineException -> toast("Failed payment")
                        is MobileSdkSecurityException -> toast(it.message!!)
                        is MobileSdkUnauthorizedException -> toast(it.message!!)
                    }
                }
        }
    }

    companion object {
        const val BIND_REQUEST_CODE = 1234
        const val PAY_REQUEST_CODE = 4321
    }
}

private fun AppCompatActivity.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
