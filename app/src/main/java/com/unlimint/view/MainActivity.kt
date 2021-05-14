package com.unlimint.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.unlimint.R
import com.unlimint.databinding.ActivityMainBinding
import com.unlimint.sdk.ui.api.UnlimintSdk
import com.unlimint.sdk.ui.api.exceptions.UnlimintSdkException
import com.unlimint.utils.ActivityResultLauncherProvider

class MainActivity : AppCompatActivity() {

    val bindCardResultLauncher = ActivityResultLauncherProvider(this)
    val paymentResultLauncher = ActivityResultLauncherProvider(this)
    val paymentWithTokenResultLauncherProvider =
        ActivityResultLauncherProvider(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setSupportActionBar(binding.toolbar)
        setContentView(binding.root)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<HomeScreenFragment>(R.id.container)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item);
        }
    }
}

fun AppCompatActivity.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.handleCancellation(resultCode: Int, data: Intent?) {
    if (Activity.RESULT_CANCELED == resultCode) {
        data?.getSerializableExtra(UnlimintSdk.ARG_EXCEPTION)?.let {
            when (it) {
                is UnlimintSdkException.ServiceUnavailable -> toast("Server error")
                is UnlimintSdkException.BindingDecline -> toast("Binding failed")
                is UnlimintSdkException.IllegalState -> toast("Illegal state error")
                is UnlimintSdkException.InternalError -> toast("Internal error")
                is UnlimintSdkException.InvalidData -> toast("Wrong card requisites")
                is UnlimintSdkException.NetworkConnection -> toast("Network connection error")
                is UnlimintSdkException.Security -> toast(it.message!!)
                is UnlimintSdkException.Timeout -> toast(it.message!!)
                is UnlimintSdkException.Unauthorized -> toast(it.message!!)
            }
        }
    }
}