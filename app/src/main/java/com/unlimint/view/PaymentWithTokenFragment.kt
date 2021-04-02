package com.unlimint.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.unlimint.App
import com.unlimint.R
import com.unlimint.databinding.FragmentPaymentWithTokenLayoutBinding
import com.unlimint.sdk.api.model.Customer
import com.unlimint.sdk.api.model.MerchantOrder
import com.unlimint.sdk.api.model.scenario.payment.Amount
import com.unlimint.sdk.api.model.scenario.payment.PaymentData
import com.unlimint.sdk.api.model.scenario.payment.TokenPayment
import com.unlimint.view.MainActivity.Companion.PAY_REQUEST_CODE
import com.unlimint.view.viewmodel.PaymentWithTokenScreenViewModel
import java.lang.IllegalStateException
import java.math.BigDecimal
import java.util.*
import javax.inject.Inject

class PaymentWithTokenFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: PaymentWithTokenScreenViewModel by viewModels { viewModelFactory }

    private var _binding: FragmentPaymentWithTokenLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPaymentWithTokenLayoutBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val activity = requireActivity() as? AppCompatActivity ?: throw IllegalStateException()

        (activity.application as App).appComponent?.inject(this)

        binding.buyButton.isEnabled = false

        binding.tokenInputLayout.editText?.doAfterTextChanged {
            val length = it?.length ?: 0
            binding.buyButton.isEnabled = length > 0
        }

        binding.buyButton.setOnClickListener {
            activity.startService(TransactionService.getNewIntent(activity))
            onPaymentWithTokenButtonClick(activity)
        }
        subscribeToErrors()

        val toolBar = activity.supportActionBar ?: return
        toolBar.setTitle(R.string.payment_with_token_toolbar_title)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onPaymentWithTokenButtonClick(activity: AppCompatActivity) {
        viewModel.pay(
            activity = activity,
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

    private fun subscribeToErrors() {
        viewModel.onBindCardError.observe(viewLifecycleOwner, { errorText ->
            Toast.makeText(activity, errorText, Toast.LENGTH_LONG).show()
        })
    }
}