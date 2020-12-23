package com.unlimint.view

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.IBinder
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.unlimint.sdk.api.MobileSdk

class TransactionService : Service() {

    override fun onBind(p0: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        LocalBroadcastManager.getInstance(this)
            .registerReceiver(listener, IntentFilter(MobileSdk.TransactionData.TRANSACTION_ACTION))
    }

    private val listener: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(cxt: Context?, intent: Intent?) {
            val transactionId = intent?.getStringExtra(MobileSdk.TransactionData.TRANSACTION_ID)
            Log.d("UnlimintSdkApp", "transactionId = $transactionId")
        }
    }

    companion object {
        fun getNewIntent(context: Context) = Intent(context, TransactionService::class.java)
    }
}
