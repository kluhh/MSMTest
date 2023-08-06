package com.example.msmtest.presentation.ui.theme.navigation

import androidx.annotation.StringRes
import com.example.msmtest.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Home : Screen("home", R.string.text_home)
    object Details : Screen("details", R.string.text_details)
}
