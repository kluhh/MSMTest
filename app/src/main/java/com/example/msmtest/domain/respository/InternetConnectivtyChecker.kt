package com.example.msmtest.domain.respository

import android.content.Context


interface InternetConnectivityChecker {
    fun isInternetAvailable(context: Context): Boolean
}
