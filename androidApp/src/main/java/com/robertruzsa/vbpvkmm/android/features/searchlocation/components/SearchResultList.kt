package com.robertruzsa.vbpvkmm.android.features.searchlocation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.robertruzsa.vbpvkmm.android.ui.components.LocalSpacing
import com.robertruzsa.vbpvkmm.features.searchlocation.domain.model.SearchResult

@Composable
fun <T> SearchResultList(
    searchResults: List<T>,
    searchFieldValue: String,
    onItemClicked: (T) -> Unit,
    searchResultItemContent: @Composable (() -> Unit)? = null,
) where T : SearchResult {
    LazyColumn {
        itemsIndexed(searchResults) { index, item ->
            searchResultItemContent?.invoke() ?: run {
                SearchResultItem(
                    item = item,
                    highlightedText = searchFieldValue,
                    onClick = onItemClicked
                )
                if (index != searchResults.lastIndex) {
                    Divider(
                        modifier = Modifier
                            .padding(horizontal = LocalSpacing.current.spacing16dp),
                        color = MaterialTheme.colors.background
                    )
                }
            }
        }
    }
}
