package com.example.msmtest.util

import android.content.Context


interface InternetConnectivityChecker {
    fun isInternetAvailable(context: Context): Boolean
}
