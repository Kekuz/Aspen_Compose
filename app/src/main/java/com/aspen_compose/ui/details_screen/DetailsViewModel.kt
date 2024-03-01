package com.aspen_compose.ui.details_screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.aspen_compose.model.Hostel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val hostel = checkNotNull(savedStateHandle.get<Hostel>("hostel"))
    val _hotelState = MutableStateFlow(hostel)
    val hotelState: StateFlow<Hostel> = _hotelState
}