package com.robertruzsa.vbpvkmm.android.features.searchlocation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.robertruzsa.vbpvkmm.android.ui.components.LocalSpacing
import com.robertruzsa.vbpvkmm.features.searchlocation.domain.model.SearchResult

@Composable
fun <T> SearchResultItem(
    item: T,
    highlightedText: String,
    onClick: (T) -> Unit
) where T : SearchResult {
    val displayName = item.displayName
    val styledText = if (displayName.contains(other = highlightedText, ignoreCase = true)) {
        val textHighlightStart = displayName.indexOf(string = highlightedText, ignoreCase = true)
        val textHighlightEnd = textHighlightStart + highlightedText.length
        AnnotatedString(
            text = displayName,
            spanStyles = listOf(
                AnnotatedString.Range(
                    item = SpanStyle(fontWeight = FontWeight.Bold),
                    start = textHighlightStart,
                    end = textHighlightEnd
                )
            )
        )
    } else {
        AnnotatedString(text = displayName)
    }
    Text(
        modifier = Modifier
            .background(MaterialTheme.colors.surface)
            .fillMaxWidth()
            .clickable {
                onClick.invoke(item)
            }
            .padding(LocalSpacing.current.spacing16dp),
        text = styledText,
        color = MaterialTheme.colors.onSurface,
        fontSize = 16.sp
    )
}
