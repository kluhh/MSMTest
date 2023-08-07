
package com.example.msmtest.presentation.people

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument

import com.example.msmtest.presentation.ui.theme.navigation.Screen
@ExperimentalMaterial3Api
@ExperimentalAnimationApi
@Composable
fun PeopleScreen(toggleTheme: () -> Unit) {
    val navController = rememberNavController()
    val viewModel : PeopleViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(
            route = Screen.Home.route,
        ) {
            Home(navController, toggleTheme)
        }
        composable(
            route = "${Screen.Details.route}/{firstname}"
//            arguments = listOf(navArgument("firstname") { type = NavType.IntType }),
        ) { backStackEntry ->
            val firstname = backStackEntry.arguments?.getString("firstname") ?: ""
            val people_item = viewModel.state.value.people.firstOrNull { it.firstName == firstname }

            if (people_item != null) {
                Details(navController, people_item)
            }
        }
    }
}

