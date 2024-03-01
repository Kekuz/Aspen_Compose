package com.aspen_compose

sealed class Screen(open val route: String) {
    object Welcome : Screen(route = "welcome_screen")
    object Main : Screen(route = "main_screen")
    data class Details(val arg: String) :
        Screen(route = "details_screen/{$arg}")
}