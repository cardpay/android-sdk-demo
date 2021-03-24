package com.unlimint.view

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.unlimint.App
import com.unlimint.R
import com.unlimint.sdk.api.MobileSdk

class TransactionService : Service() {

    override fun onBind(p0: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        LocalBroadcastManager.getInstance(this)
            .registerReceiver(
                SDKBroadcastReceiver(),
                IntentFilter(MobileSdk.TransactionData.TRANSACTION_ACTION)
            )

        startForeground(1, getNotification())
    }

    /**
     * Broadcast Receiver that catch message from [MobileSdk]
     **/
    private class SDKBroadcastReceiver : BroadcastReceiver() {
        override fun onReceive(cxt: Context?, intent: Intent?) {
            val transactionId = intent?.getStringExtra(MobileSdk.TransactionData.TRANSACTION_ID)
            Log.d("UnlimintSdkApp", "transactionId = $transactionId")

            val insecure =
                intent?.getBooleanExtra(MobileSdk.TransactionData.INSECURE_EVENT, false) ?: false
            if (insecure) {
                val message = "Merchant message: Device is insecure"
                Toast.makeText(cxt, message, Toast.LENGTH_SHORT).show()
                Log.d("UnlimintSdkApp", message)
            }
        }
    }

    /**
     * Broadcast Receiver that catch message from [Notification].
     * Catch message for [MobileSdk.close]
     **/
    class CloseSdkNotificationBroadcastReceiver : BroadcastReceiver() {

        override fun onReceive(cxt: Context?, intent: Intent?) {
            if (intent?.getBooleanExtra(EXTRA_KEY, false) == true) {
                cxt?.let { MobileSdk.close(cxt) }
            }
        }

        companion object {
            const val EXTRA_KEY = "CLOSE_SDK_EXTRA_KEY"
        }
    }

    private fun getNotification(): Notification {
        val intent = Intent(this, CloseSdkNotificationBroadcastReceiver::class.java)
        intent.putExtra(CloseSdkNotificationBroadcastReceiver.EXTRA_KEY, true)

        val pendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            0,
            intent,
            PendingIntent.FLAG_CANCEL_CURRENT
        )

        val notificationBuilder =
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                NotificationCompat.Builder(this, App.NOTIFICATION_CHANNEL)
            } else {
                @Suppress("DEPRECATION")
                NotificationCompat.Builder(this)
            }

        return notificationBuilder
            .setContentTitle("Click to close SDK")
            .setSmallIcon(R.drawable.ic_notification_logo)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()
    }

    companion object {
        fun getNewIntent(context: Context) = Intent(context, TransactionService::class.java)
    }
}
