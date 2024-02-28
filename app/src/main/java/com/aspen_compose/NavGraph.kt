package com.aspen_compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aspen_compose.ui.details_screen.DetailsScreen
import com.aspen_compose.ui.main_screen.MainScreen
import com.aspen_compose.ui.welcome_screen.WelcomeScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
){
    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route
    ){
        composable(
            route = Screen.Welcome.route
        ){
            WelcomeScreen(navController = navController)
        }
        composable(
            route = Screen.Main.route
        ){
            MainScreen(navController = navController)
        }
        composable(
            route = Screen.Details.route
        ){
            DetailsScreen(navController = navController)
        }
    }
}