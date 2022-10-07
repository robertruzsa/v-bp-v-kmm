package com.robertruzsa.vbpvkmm.android.features.searchlocation.components

sealed class SearchUIState {
    object Idle : SearchUIState()
    object Loading : SearchUIState()
    object Success : SearchUIState()
    object Error : SearchUIState()
}
