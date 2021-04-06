package com.unlimint.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.unlimint.databinding.PaymentMethodHolderLayoutBinding
import com.unlimint.utils.RecyclerViewClickListener

class PaymentMethodsRecyclerAdapter(private val methodsNames: List<String>) :
    RecyclerView.Adapter<PaymentMethodsRecyclerAdapter.PaymentMethodHolder>() {

    var clickListeners: List<RecyclerViewClickListener<String>>? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PaymentMethodsRecyclerAdapter.PaymentMethodHolder {
        return PaymentMethodHolder(
            PaymentMethodHolderLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PaymentMethodHolder, position: Int) {
        holder.bindMethodName(methodsNames[position])
    }

    override fun getItemCount(): Int = methodsNames.size

    inner class PaymentMethodHolder(
        private val paymentMethodHolderLayoutBinding: PaymentMethodHolderLayoutBinding
    ) : RecyclerView.ViewHolder(paymentMethodHolderLayoutBinding.root) {

        init {
            paymentMethodHolderLayoutBinding.root.setOnClickListener {
                clickListeners?.forEach {
                    it.onClicked(methodsNames[adapterPosition])
                }
            }
        }

        fun bindMethodName(name: String) {
            paymentMethodHolderLayoutBinding.methodName.text = name
        }
    }
}
