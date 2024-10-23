package com.kodeflap.paymentgateways.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PaymentGatewayOptions(onGatewaySelected: (String) -> Unit) {

    val paymentGatewayOptions = listOf("RazorPay", "Stripe", "Paypal")
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        paymentGatewayOptions.forEach { gateway ->
            GatewayButton(gateway, onGatewaySelected)
        }
    }
}