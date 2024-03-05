package com.aspen_compose.ui.navigation

sealed class Destinations(val route: String) {
    data class Details(private val args: Int) :
        Destinations(route = "details_screen/$args") {
    }
}