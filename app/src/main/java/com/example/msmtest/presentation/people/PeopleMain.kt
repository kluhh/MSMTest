
package com.example.msmtest.presentation.people

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.msmtest.presentation.people.Details
import com.example.msmtest.presentation.people.Home
import com.example.msmtest.presentation.ui.theme.navigation.Screen

/*@ExperimentalAnimationApi
@Composable
fun PeopleScreen(toggleTheme: () -> Unit) {

    // Create and register the custom navigator
    val animatedComposableNavigator = AnimatedComposableNavigator()
    val navController = rememberNavController()
//    navController.navigatorProvider.addNavigator(animatedComposableNavigator)


//    val navController = rememberNavController()
    AnimatedNavHost(navController, startDestination = Screen.Home.route) {
        composable(
            Screen.Home.route,
            exitTransition = { _, _ ->
                slideOutHorizontally(
                    targetOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))
            },
            popEnterTransition = { _, _ ->
                slideInHorizontally(
                    initialOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(300))
            },
        ) {
            Home(navController, toggleTheme)
        }
        composable(
            "${Screen.Details.route}/{id}/{title}/{location}",
            enterTransition = { _, _ ->
                slideInHorizontally(
                    initialOffsetX = { 300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(300))
            },
            exitTransition = { _, _ ->
                slideOutHorizontally(
                    targetOffsetX = { 300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))
            },
            //            arguments = listOf(navArgument("id") { type = NavType.IntType })
            arguments = listOf()
        ) {
            Details(navController, it.arguments?.getInt("id") ?: 0)
        }
    }
}*/



@ExperimentalMaterial3Api
@ExperimentalAnimationApi
@Composable
fun PeopleScreen(toggleTheme: () -> Unit) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(
            route = Screen.Home.route,
        ) {
            Home(navController, toggleTheme)
        }
        composable(
            route = "${Screen.Details.route}/{name}/{birthday}",
            arguments = listOf(navArgument("id") { type = NavType.IntType }),
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            Details(navController, id)
        }
    }
}

