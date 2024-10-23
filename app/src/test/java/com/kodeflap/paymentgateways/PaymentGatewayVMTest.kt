package com.kodeflap.paymentgateways

import androidx.compose.runtime.ExperimentalComposeApi
import com.kodeflap.paymentgateways.viewmodels.PaymentGatewayVM
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest

import org.junit.Before
import org.junit.Test


@OptIn(ExperimentalComposeApi::class)
class PaymentGatewayVMTest {
    private lateinit var viewModel: PaymentGatewayVM

    @Before
    fun setUp() {
        viewModel = PaymentGatewayVM()
    }
    @Test
    fun selectedGateway() = runTest {
        val gateway = "Stripe"
        viewModel.selectedGateway(gateway)

        val result = viewModel.selectedGateway.first()
        assertEquals(gateway, result)
    }

}