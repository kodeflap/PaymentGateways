package com.kodeflap.paymentgateways.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.unit.dp

@Composable
fun GatewayButton(value: String, onGatewaySelected: (String) -> Unit) {
    Button(
        modifier = Modifier.padding(16.dp),
        elevation = ButtonDefaults.elevatedButtonElevation(5.dp),
        onClick = { onGatewaySelected(value) }
    ) {
        Text(value)
    }
}