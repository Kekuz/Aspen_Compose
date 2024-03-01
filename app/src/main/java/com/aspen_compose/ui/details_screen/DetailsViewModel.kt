package com.aspen_compose.ui.details_screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.aspen_compose.mockup.Mockup
import com.aspen_compose.model.Hostel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val hostelId = checkNotNull(savedStateHandle.get<Int>("hostel"))
    private val _hostelState = MutableStateFlow(Mockup.getHostelById(hostelId))
    val hotelState: StateFlow<Hostel> = _hostelState
}