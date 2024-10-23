package com.kodeflap.paymentgateways.composables

import android.app.Activity
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kodeflap.paymentgateways.viewmodels.PaymentGatewayVM
import com.kodeflap.paymentgateways.viewmodels.RazorPaymentVM

@Composable
fun PaymentGatewayHomeScreen(viewModel: RazorPaymentVM = viewModel()) {
    val paymentStatus by viewModel.paymentStatus.observeAsState()
    val context = LocalContext.current

    // Cast the context to an Activity
    val activity = context as? Activity

    PaymentGatewayOptions(onGatewaySelected = { gateway ->
        if (gateway == "RazorPay" && activity != null) {
            viewModel.initRazorPay(activity, 100.0)
        } // Example amount
    })

    // Show payment status
    paymentStatus?.let {
        Toast.makeText(context, it, Toast.LENGTH_LONG).show()
    }
}