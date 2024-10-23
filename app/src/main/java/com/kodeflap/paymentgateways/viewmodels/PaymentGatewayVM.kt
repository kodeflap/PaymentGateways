package com.kodeflap.paymentgateways.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PaymentGatewayVM: ViewModel() {
    private val _selectedGateway = MutableStateFlow<String?>(null)
    val selectedGateway: StateFlow<String?> = _selectedGateway

    fun selectedGateway(gateway: String) {
        _selectedGateway.value = gateway

        when(_selectedGateway.value) {
            "RazorPay" -> {
                performRazorPay()
            }
        }
    }

    private fun performRazorPay() {
        TODO("Not yet implemented")
    }
}