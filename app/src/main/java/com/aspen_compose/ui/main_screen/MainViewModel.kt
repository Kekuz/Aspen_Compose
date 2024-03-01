package com.aspen_compose.ui.main_screen

import androidx.lifecycle.ViewModel
import com.aspen_compose.mockup.Mockup
import com.aspen_compose.model.Hostel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    //UI state
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    private val _hotelsState = MutableStateFlow(Mockup.hostels())
    val hotelsState: StateFlow<List<Hostel>> = _hotelsState
}