package com.unlimint.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.unlimint.App
import com.unlimint.R
import com.unlimint.databinding.FragmentPaymentMethodsLayoutBinding
import com.unlimint.navigation.NavigationHelper.navigateTo
import com.unlimint.sdk.ui.api.model.TokenPayment
import com.unlimint.sdk.ui.api.model.info.Customer
import com.unlimint.sdk.ui.api.model.info.MerchantOrder
import com.unlimint.sdk.ui.api.model.payment.Amount
import com.unlimint.sdk.ui.api.model.payment.PaymentData
import com.unlimint.utils.ActivityResultLauncherProvider
import com.unlimint.utils.ActivityResultListener
import com.unlimint.utils.RecyclerViewClickListener
import com.unlimint.view.viewmodel.PaymentMethodScreenViewModel
import java.lang.IllegalStateException
import java.math.BigDecimal
import java.util.*
import javax.inject.Inject

class PaymentMethodFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var launcherProvider: ActivityResultLauncherProvider

    private val viewModel: PaymentMethodScreenViewModel by viewModels { viewModelFactory }

    private var _binding: FragmentPaymentMethodsLayoutBinding? = null
    private val binding get() = _binding!!
    private lateinit var linearLayoutManager: LinearLayoutManager


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
        val activity = requireActivity() as? MainActivity ?: throw IllegalStateException()
        launcherProvider = activity.paymentResultLauncher
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

        val methodPaymentName = getString(R.string.method_payment_name)
        val methodPaymentWithTokenName = getString(R.string.method_payment_with_token_name)
        val methodPaymentWithPayPal = "PayPal"
        val methodPaymentWithSavedToken = "Saved card 4000 .... .... 0002"

        val paymentMethods: List<String> = listOf(
            methodPaymentName,
            methodPaymentWithTokenName,
            methodPaymentWithPayPal,
            methodPaymentWithSavedToken
        )

        val recyclerViewAdapter = PaymentMethodsRecyclerAdapter(paymentMethods)

        linearLayoutManager = LinearLayoutManager(requireActivity())
        binding.recyclerView.layoutManager = linearLayoutManager
        binding.recyclerView.adapter = recyclerViewAdapter
        binding.recyclerView.addItemDecoration(
            DividerItemDecorator(R.drawable.divider)
        )

        recyclerViewAdapter.clickListeners = listOf(
            RecyclerViewClickListener(defaultInterval = 4000) { methodName ->
                if (methodName == methodPaymentName) {
                    activity.startService(TransactionService.getNewIntent(activity))
                    onPaymentButtonClick(activity)
                }
            },
            RecyclerViewClickListener() { methodName ->
                if (methodName == methodPaymentWithTokenName) {
                    activity.navigateTo(PaymentWithTokenFragment())
                }
            },
            RecyclerViewClickListener() { methodName ->
                if (methodName == methodPaymentWithPayPal) {
                    activity.startService(TransactionService.getNewIntent(activity))
                    onPaymentWithPayPalButtonClick(activity)
                }
            },
            RecyclerViewClickListener() { methodName ->
                if (methodName == methodPaymentWithSavedToken) {
                    activity.startService(TransactionService.getNewIntent(activity))
                    onPaymentWithTokenButtonClick(activity)
                }
            }
        )

        subscribeToErrors()

        val toolBar = activity.supportActionBar ?: return
        toolBar.title = ""
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
            launcher = launcherProvider.launcher
        )
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
                    token = "a3d85ac0-4268-bb12-a628-f1e13a4988d8",
                    last4PanDigits = "0002"
                )
            ),
            launcher = launcherProvider.launcher
        )
    }

    private fun onPaymentWithPayPalButtonClick(activity: AppCompatActivity) {
        viewModel.payWithPayPal(
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
            launcher = launcherProvider.launcher
        )
    }

    private fun subscribeToErrors() {
        viewModel.onBindCardError.observe(viewLifecycleOwner, { errorText ->
            Toast.makeText(activity, errorText, Toast.LENGTH_LONG).show()
        })
    }
}