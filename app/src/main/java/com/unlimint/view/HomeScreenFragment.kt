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
import com.unlimint.databinding.FragmentHomeScreenLayoutBinding
import com.unlimint.navigation.NavigationHelper.navigateTo
import com.unlimint.sdk.api.model.Customer
import com.unlimint.utils.setOnSingleClickListener
import com.unlimint.view.MainActivity.Companion.BIND_REQUEST_CODE
import com.unlimint.view.viewmodel.HomeScreenViewModel
import java.lang.IllegalStateException
import java.util.*
import javax.inject.Inject

class HomeScreenFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val activity = requireActivity() as? AppCompatActivity ?: throw IllegalStateException()

        (activity.application as App).appComponent?.inject(this)

        binding.buyButton.setOnClickListener {
            activity.navigateTo(PaymentMethodFragment())
        }
        binding.bankCardButton.setOnSingleClickListener {
            activity.startService(TransactionService.getNewIntent(activity))
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

    private fun onBindButtonClick(activity: AppCompatActivity) {
        viewModel.bindCard(
            activity = activity,
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

    private fun subscribeToErrors() {
        viewModel.onBindCardError.observe(viewLifecycleOwner, { errorText ->
            Toast.makeText(activity, errorText, Toast.LENGTH_LONG).show()
        })
    }
}