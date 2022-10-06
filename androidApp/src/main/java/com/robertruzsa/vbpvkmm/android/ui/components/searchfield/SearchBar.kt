package com.robertruzsa.vbpvkmm.android.ui.components.searchfield

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import com.robertruzsa.vbpvkmm.android.ui.components.LocalSpacing

@Composable
fun SearchBar(
    searchFieldModifier: Modifier = Modifier,
    label: String,
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit = {},
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onImeAction: KeyboardActionScope.() -> Unit = {},
    onNavigationIconClick: () -> Unit = {},
    onClearTextClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.surface)
            .padding(
                top = LocalSpacing.current.spacing8dp,
                end = LocalSpacing.current.spacing8dp,
                bottom = LocalSpacing.current.spacing8dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onNavigationIconClick
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                tint = MaterialTheme.colors.onSurface,
                contentDescription = null
            )
        }
        SearchField(
            modifier = Modifier
                .weight(1f)
                .then(searchFieldModifier),
            hint = label,
            value = value,
            onValueChange = onValueChange,
            keyboardType = keyboardType,
            imeAction = imeAction,
            onImeAction = onImeAction,
            onClearTextClick = onClearTextClick
        )
    }
}
