package com.example.msmtest.util

import android.content.Context
import android.net.ConnectivityManager

import android.net.NetworkInfo

object InternetConnectivityHelper {

    // Method to check if the device is connected to the internet
    fun isInternetAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}
