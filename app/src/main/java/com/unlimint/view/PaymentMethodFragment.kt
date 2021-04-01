package com.unlimint.view

import android.os.Bundle
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
import com.unlimint.databinding.FragmentPaymentMethodsLayoutBinding
import com.unlimint.navigation.NavigationHelper.navigateTo
import com.unlimint.sdk.api.model.Customer
import com.unlimint.sdk.api.model.MerchantOrder
import com.unlimint.sdk.api.model.scenario.payment.Amount
import com.unlimint.sdk.api.model.scenario.payment.PaymentData
import com.unlimint.view.MainActivity.Companion.PAY_REQUEST_CODE
import com.unlimint.view.viewmodel.PaymentMethodScreenViewModel
import java.lang.IllegalStateException
import java.math.BigDecimal
import java.util.*
import javax.inject.Inject

class PaymentMethodFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: PaymentMethodScreenViewModel by viewModels { viewModelFactory }

    private var _binding: FragmentPaymentMethodsLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPaymentMethodsLayoutBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity() as? AppCompatActivity ?: throw IllegalStateException()

        (activity.application as App).appComponent?.inject(this)

        binding.paymentButton.setOnClickListener {
            activity.startService(TransactionService.getNewIntent(activity))
            onPaymentButtonClick(activity)
        }
        binding.paymentWithTokenButton.setOnClickListener {
            activity.navigateTo(PaymentWithTokenFragment())
        }
        subscribeToErrors()

        val toolBar = activity.supportActionBar ?: return
        toolBar.setTitle(R.string.payment_methods_toolbar_title)
        toolBar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onPaymentButtonClick(activity: AppCompatActivity) {
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
            paymentRequestCode = PAY_REQUEST_CODE
        )
    }

    private fun subscribeToErrors() {
        viewModel.onBindCardError.observe(viewLifecycleOwner, { errorText ->
            Toast.makeText(activity, errorText, Toast.LENGTH_LONG).show()
        })
    }
}