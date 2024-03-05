package com.aspen_compose.ui.main_screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aspen_compose.mockup.Mockup
import com.aspen_compose.model.Hostel
import com.aspen_compose.network.repository.CitiesRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val citiesRepositoryImpl: CitiesRepositoryImpl,
) : ViewModel() {

    //UI state
    //private val _uiState = MutableStateFlow(MainUiState.)
    //val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    private val _hotelsState = MutableStateFlow(Mockup.hostels())
    val hotelsState: StateFlow<List<Hostel>> = _hotelsState

    private val _cities = MutableStateFlow(emptyList<String>())
    val cities: StateFlow<List<String>> = _cities

    init {
        search()
    }

    private fun search() {
        //stateLiveData.value = SearchState.Loading
        viewModelScope.launch {
            citiesRepositoryImpl.search().collect {
                val response = it.first
                val errorMessage = it.second
                if (response != null) {
                    Log.e("Response", response.toString())
                    if (response.states.isNotEmpty()) {
                        _cities.value = response.states.map { state -> state.name }
                        //stateLiveData.postValue(SearchState.Content(response.results))
                        //Log.d("Page", currentPage.toString())
                    }
                } else if (errorMessage != null) {
                    Log.e("Response", "Error")
                    //getCharactersFromDatabase(errorMessage)
                }
            }
        }
    }
}