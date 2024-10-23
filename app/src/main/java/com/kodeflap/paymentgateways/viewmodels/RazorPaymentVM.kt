package com.kodeflap.paymentgateways.viewmodels

import android.app.Activity
import android.app.Application
import android.icu.util.Currency
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import org.json.JSONObject

class RazorPaymentVM(application: Application) : AndroidViewModel(application),
    PaymentResultListener {
    private val _paymentStatus = MutableLiveData<String>()
    val paymentStatus: LiveData<String> get() = _paymentStatus

    fun initRazorPay(activity: Activity, amt: Double, currency: String = "INR") {

        val checkout: Checkout = Checkout()
        checkout.setKeyID("rzp_test_Nqy8gmPWtyPySL")

        try {
            val options = JSONObject()
            options.put("name", "Your Company Name")
            options.put("description", "Test Payment")
            options.put(
                "image",
                "https://your-logo-url.com/logo.png"
            ) // Optional, replace with your logo URL
            options.put("currency", currency)
            options.put("amount", (amt * 100).toInt()) // Amount is in paise, so multiply by 100

            val prefill = JSONObject()
            prefill.put("email", "user@example.com")
            prefill.put("contact", "9876543210")

            options.put("prefill", prefill)

            // Start the payment process
            checkout.open(activity, options)
        } catch (e: Exception) {
            _paymentStatus.postValue("${e.message}")
        }
    }

    override fun onPaymentSuccess(razorpayPaymentID: String?) {
        _paymentStatus.postValue("Payment Successful: $razorpayPaymentID")
    }

    override fun onPaymentError(code: Int, description: String?) {
        _paymentStatus.postValue("Payment Failed: $description")
    }
}