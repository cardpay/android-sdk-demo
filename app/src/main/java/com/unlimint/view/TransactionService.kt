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
import com.unlimint.sdk.ui.api.UnlimintSdk
import timber.log.Timber

class TransactionService : Service() {

    private val securityReceiver = SDKSecurityBroadcastReceiver()

    override fun onBind(p0: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()

        LocalBroadcastManager.getInstance(this)
            .registerReceiver(
                securityReceiver,
                IntentFilter(UnlimintSdk.SecurityData.SECURITY_ACTION)
            )

        startForeground(1, getNotification())
    }

    override fun onDestroy() {
        super.onDestroy()
        stopForeground(true)
        LocalBroadcastManager.getInstance(this).unregisterReceiver(securityReceiver)
    }

    /**
     * Broadcast Receiver that catch security message from [MobileSdk]
     **/
    private class SDKSecurityBroadcastReceiver : BroadcastReceiver() {
        override fun onReceive(cxt: Context?, intent: Intent?) {
            val securityMessage =
                when (intent?.getStringExtra(UnlimintSdk.SecurityData.SECURITY_EXTRA).orEmpty()) {
                    UnlimintSdk.SecurityData.SECURE_EVENT -> "Security check is successfull"
                    UnlimintSdk.SecurityData.MAYBE_INSECURE_EVENT -> "Device is maybe rooted"
                    UnlimintSdk.SecurityData.INSECURE_EVENT -> "Device is insecure"
                    else -> null
                }

            val message = "Merchant message: $securityMessage"
            Toast.makeText(cxt, message, Toast.LENGTH_SHORT).show()
            Timber.tag("UnlimintSdkApp").d(message)
        }
    }

    /**
     * Broadcast Receiver that catch message from [Notification].
     * Catch message for [MobileSdk.close]
     **/
    class CloseSdkNotificationBroadcastReceiver : BroadcastReceiver() {

        override fun onReceive(cxt: Context?, intent: Intent?) {
            if (intent?.getBooleanExtra(EXTRA_KEY, false) == true) {
                cxt?.let { UnlimintSdk.close(cxt) }
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
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()
    }

    companion object {
        fun getNewIntent(context: Context) = Intent(context, TransactionService::class.java)
    }
}
