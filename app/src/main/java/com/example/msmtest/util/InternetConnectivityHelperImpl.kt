package com.example.msmtest.util

import android.content.Context

class InternetConnectivityHelperImpl : InternetConnectivityChecker {
    override fun isInternetAvailable(context: Context): Boolean {
        return InternetConnectivityHelper.isInternetAvailable(context)
    }
}
