package com.aspen_compose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aspen_compose.ui.details_screen.DetailsScreen
import com.aspen_compose.ui.details_screen.DetailsViewModel
import com.aspen_compose.ui.main_screen.MainScreen
import com.aspen_compose.ui.main_screen.MainViewModel
import com.aspen_compose.ui.welcome_screen.WelcomeScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route
    ) {
        composable(
            route = Screen.Welcome.route
        ) {

            WelcomeScreen(navController = navController)
        }
        composable(
            route = Screen.Main.route
        ) {

            MainScreen(navController = navController)
        }
        composable(
            route = Screen.Details("hostel").route,
            arguments = listOf(
                navArgument("hostel") {
                    type = NavType.IntType
                }
            )
        ) {

            DetailsScreen(navController = navController)
        }
    }
}