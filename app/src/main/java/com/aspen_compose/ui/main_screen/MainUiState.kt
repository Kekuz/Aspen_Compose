package com.aspen_compose.ui.main_screen

sealed class MainUiState() {
    object Loading : MainUiState()
    data class Content(
        val cities: List<String>
    ) : MainUiState()

    data class Error(
        val errorMessage: String
    ) : MainUiState()
}