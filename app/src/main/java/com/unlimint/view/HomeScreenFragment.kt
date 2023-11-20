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
import com.unlimint.App
import com.unlimint.R
import com.unlimint.databinding.FragmentHomeScreenLayoutBinding
import com.unlimint.sdk.ui.api.model.common.Customer
import com.unlimint.sdk.ui.api.model.common.MerchantOrder
import com.unlimint.sdk.ui.api.model.common.Amount
import com.unlimint.sdk.ui.api.model.common.PaymentData
import com.unlimint.sdk.ui.api.model.common.TokenizedCardOrder
import com.unlimint.utils.ActivityResultLauncherProvider
import com.unlimint.utils.ActivityResultListener
import com.unlimint.utils.setOnSingleClickListener
import com.unlimint.view.viewmodel.HomeScreenViewModel
import java.lang.IllegalStateException
import java.math.BigDecimal
import java.util.*
import javax.inject.Inject

class HomeScreenFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var launcherProvider: ActivityResultLauncherProvider

    private val viewModel: HomeScreenViewModel by viewModels { viewModelFactory }

    private var _binding: FragmentHomeScreenLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeScreenLayoutBinding.inflate(
            inflater,
            container,
            false
        )
        val activity = requireActivity() as? MainActivity ?: throw IllegalStateException()
        launcherProvider = activity.bindCardResultLauncher
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

        binding.buyButton.isEnabled = true

        binding.buyButton.setOnClickListener {
            onPayButtonClick(activity)
//            activity.navigateTo(PaymentMethodFragment())
        }
        binding.bankCardButton.setOnSingleClickListener {
            onBindButtonClick(activity)
        }
        subscribeToErrors()

        val toolbar = activity.supportActionBar ?: return
        toolbar.setTitle(R.string.home_screen_toolbar_title)
        toolbar.setDisplayHomeAsUpEnabled(false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onPayButtonClick(activity: AppCompatActivity) {
        val tokenData = TokenizedCardOrder.TokenData(
            token = "a3d85ac0-4268-bb12-a628-f1e13a4988d8",
            maskedPan = "0002"
        )
        val cardAccount = TokenizedCardOrder.CardAccount(tokenData)

        viewModel.pay(
            activity = activity,
            merchantName = "merchantName",
            customer = Customer(
                id = "656945944",
                email = "cardpay.test.mobile@gmail.com"
            ),
            launcher = launcherProvider.launcher,
            cardAccount = arrayListOf(cardAccount),
            merchantOrder = MerchantOrder(
                description = "merchant order description",
                id = "merchant order id"
            ),
            paymentData = PaymentData(
                amount = Amount(
                    value = BigDecimal.valueOf(1.0),
                    currency = Currency.getInstance("EUR")
                )
            )
        )
    }

    private fun onBindButtonClick(activity: AppCompatActivity) {
        viewModel.bindCard(
            activity = activity,
            currency = Currency.getInstance("EUR"),
            customer = Customer(
                id = "656945944",
                email = "cardpay.test.mobile@gmail.com"
            ),
            launcher = launcherProvider.launcher,
            cardAccount = null,
            merchantOrder = null
        )
    }

    private fun subscribeToErrors() {
        viewModel.onBindCardError.observe(viewLifecycleOwner, { errorText ->
            Toast.makeText(activity, errorText, Toast.LENGTH_LONG).show()
        })
    }
}