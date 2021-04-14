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
import com.unlimint.sdk.api.MobileSdk
import com.unlimint.sdk.api.exceptions.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val BIND_REQUEST_CODE = 1234
        const val PAY_REQUEST_CODE = 4321
    }

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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        handleCancellation(resultCode, data)
    }

    private fun handleCancellation(resultCode: Int, data: Intent?) {
        if (Activity.RESULT_CANCELED == resultCode) {
            data?.getSerializableExtra(MobileSdk.ARG_EXCEPTION)?.let {
                when (it) {
                    is MobileSdkServiceUnavailableException -> toast("Server error")
                    is MobileSdkIllegalStateException -> toast("Internal error")
                    is MobileSdkBindingDeclineException -> toast("Failed binding")
                    is MobileSdkSecurityException -> toast(it.message!!)
                    is MobileSdkUnauthorizedException -> toast(it.message!!)
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item);
        }
    }
}

private fun AppCompatActivity.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
