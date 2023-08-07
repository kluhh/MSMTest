package com.example.msmtest.domain.respository

import android.content.Context
import com.example.msmtest.util.InternetConnectivityHelper

class InternetConnectivityHelperImpl : InternetConnectivityChecker {
    override fun isInternetAvailable(context: Context): Boolean {
        return InternetConnectivityHelper.isInternetAvailable(context)
    }
}
