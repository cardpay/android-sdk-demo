package com.unlimint.view

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.unlimint.App
import com.unlimint.R
import com.unlimint.databinding.FragmentPaymentWithTokenLayoutBinding
import com.unlimint.sdk.ui.api.model.TokenPayment
import com.unlimint.sdk.ui.api.model.info.Customer
import com.unlimint.sdk.ui.api.model.info.MerchantOrder
import com.unlimint.sdk.ui.api.model.payment.Amount
import com.unlimint.sdk.ui.api.model.payment.PaymentData
import com.unlimint.utils.ActivityResultLauncherProvider
import com.unlimint.utils.ActivityResultListener
import com.unlimint.utils.setOnSingleClickListener
import com.unlimint.view.viewmodel.PaymentWithTokenScreenViewModel
import java.lang.IllegalStateException
import java.math.BigDecimal
import java.util.*
import javax.inject.Inject

class PaymentWithTokenFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var launcherProvider: ActivityResultLauncherProvider

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
        val activity = requireActivity() as? MainActivity ?: throw IllegalStateException()
        launcherProvider = activity.paymentWithTokenResultLauncherProvider
        launcherProvider.activityResultListener = object : ActivityResultListener {
            override fun onReceiveResult(resultCode: Int, data: Intent?) {
                activity.handleCancellation(resultCode, data)
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val activity = requireActivity() as? AppCompatActivity ?: throw IllegalStateException()

        (activity.application as App).appComponent?.inject(this)

        val textInput = binding.tokenInputLayout

        textInput.addTextWatcher(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //not implemented
            }

            override fun afterTextChanged(s: Editable?) {
                //not implemented
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val length = s?.length ?: 0
                binding.buyButton.isEnabled = length > 0
            }
        })

        binding.buyButton.setOnSingleClickListener {
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
                    token = binding.tokenInputLayout.input.text.toString(),
                    last4PanDigits = "1234"
                )
            ),
            launcher = launcherProvider.launcher
        )
    }

    private fun subscribeToErrors() {
        viewModel.onBindCardError.observe(viewLifecycleOwner, { errorText ->
            Toast.makeText(activity, errorText, Toast.LENGTH_LONG).show()
        })
    }
}