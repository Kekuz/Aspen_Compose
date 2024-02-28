package com.aspen_compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

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