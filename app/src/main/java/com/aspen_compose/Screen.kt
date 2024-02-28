package com.aspen_compose

sealed class Screen(val route: String) {
    object Welcome : Screen(route = "welcome_screen")
    object Main : Screen(route = "main_screen")
    object Details : Screen(route = "details_screen")
}