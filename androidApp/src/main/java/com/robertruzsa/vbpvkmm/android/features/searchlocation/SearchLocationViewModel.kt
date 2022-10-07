package com.robertruzsa.vbpvkmm.android.features.searchlocation

import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.robertruzsa.vbpvkmm.android.features.searchlocation.components.SearchUIState
import com.robertruzsa.vbpvkmm.features.offers.domain.model.Location
import com.robertruzsa.vbpvkmm.features.searchlocation.domain.repository.SearchLocationRepository
import com.robertruzsa.vbpvkmm.features.searchoffers.domain.LocationInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchLocationViewModel @Inject constructor(
    private val locationSearchRepository: SearchLocationRepository
) : ViewModel() {

    private val _query = MutableStateFlow(TextFieldValue(""))
    val query = _query.asStateFlow()

    private val _searchResults = MutableStateFlow<List<Location>>(emptyList())
    val searchResult = _searchResults.asStateFlow()

    private val _uiState = MutableStateFlow<SearchUIState>(SearchUIState.Idle)
    val uiState = _uiState.asStateFlow()

    var locationType: LocationInfo? = null

    private var searchJob: Job? = null

    init {
        search("")
    }

    fun onQueryChanged(textFieldValue: TextFieldValue) {
        val newText = textFieldValue.text
        val currentQuery = query.value.text.trim()
        _query.value = textFieldValue.copy(text = newText)
        val newQuery = newText.trim()
        if (newQuery != currentQuery) {
            delayedSearch(newQuery)
        }
    }

    private fun delayedSearch(query: String) {
        searchJob?.cancel()
        _uiState.value = SearchUIState.Loading
        searchJob = viewModelScope.launch {
            delay(SEARCH_DELAY_MILLIS)
            search(query)
        }
    }

    private fun search(query: String) = viewModelScope.launch {
        _searchResults.value = locationSearchRepository.search(query)
        _uiState.value = SearchUIState.Success
    }

    fun setLocation(locationType: LocationInfo) {
        this.locationType = locationType
        val locationName = locationType.location.name
        _query.value = _query.value.copy(
            text = locationType.location.name,
            selection = TextRange(locationName.length)
        )
    }

    fun onLocationSelected(value: Location) {
        locationType?.location = value
    }

    fun onClearTextClicked() {
        _query.value = TextFieldValue("")
    }

    companion object {
        const val SEARCH_DELAY_MILLIS: Long = 1000
    }
}
