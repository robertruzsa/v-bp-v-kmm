package com.robertruzsa.vbpvkmm.android.features.searchlocation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.robertruzsa.vbpvkmm.android.ui.components.LocalSpacing
import com.robertruzsa.vbpvkmm.android.ui.components.searchfield.SearchBar
import com.robertruzsa.vbpvkmm.features.searchlocation.domain.model.SearchResult

@Composable
fun <T> SearchScreen(
    searchFieldModifier: Modifier = Modifier,
    searchFieldValue: TextFieldValue,
    onSearchFieldValueChange: (TextFieldValue) -> Unit,
    searchResults: List<T>,
    onItemSelected: (T) -> Unit,
    onSearchFieldImeAction: KeyboardActionScope.() -> Unit = {},
    onNavigationIconClick: () -> Unit = {},
    onClearTextClick: () -> Unit = {},
    uiState: SearchUIState = SearchUIState.Idle,
    modifier: Modifier = Modifier
) where T : SearchResult {
    Column(
        modifier = modifier
            .background(MaterialTheme.colors.background)
            .fillMaxSize()
    ) {
        SearchBar(
            searchFieldModifier = searchFieldModifier,
            value = searchFieldValue,
            onValueChange = onSearchFieldValueChange,
            label = "Keresés",
            imeAction = ImeAction.Done,
            onImeAction = onSearchFieldImeAction,
            onNavigationIconClick = onNavigationIconClick,
            onClearTextClick = onClearTextClick
        )

        when (uiState) {
            SearchUIState.Idle -> Unit
            SearchUIState.Error -> Unit
            SearchUIState.Loading ->
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(LocalSpacing.current.spacing16dp),
                    color = MaterialTheme.colors.primary
                )
            SearchUIState.Success ->
                if (searchResults.isNotEmpty()) {
                    SearchResultList(
                        searchFieldValue = searchFieldValue.text,
                        searchResults = searchResults,
                        onItemClicked = onItemSelected
                    )
                } else {
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(16.dp),
                        text = "Nincs találat"
                    )
                }
        }
    }
}
