package com.robertruzsa.vbpvkmm.android.ui.components.textfield

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun BaseTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: TextFieldValue,
    enabled: Boolean = true,
    isReadOnly: Boolean = false,
    onClick: () -> Unit = {},
    onValueChange: (TextFieldValue) -> Unit = {},
    isValid: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onImeAction: KeyboardActionScope.() -> Unit = {},
    emptyError: String? = null,
    validationError: String? = null,
    showError: Boolean = false,
) {

    var isFocusedDirty by remember { mutableStateOf(false) }
    var showErrorOnFocusChange by remember { mutableStateOf(false) }

    val displayError = showError || showErrorOnFocusChange

    Box {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                OutlinedTextField(
                    isError = if (emptyError != null) {
                        displayError && (!isValid || value.text.isBlank())
                    } else {
                        displayError && !isValid
                    },
                    enabled = enabled,
                    modifier = modifier.onFocusChanged { focusState ->
                        val focused = focusState.isFocused
                        if (focused) isFocusedDirty = true
                        if (!focused) {
                            if (isFocusedDirty) {
                                showErrorOnFocusChange = true
                            }
                        }
                    },
                    label = {
                        Text(
                            text = label,
                        )
                    },
                    value = value,
                    textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
                    onValueChange = {
                        onValueChange(it)
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = keyboardType,
                        imeAction = imeAction,
                    ),
                    keyboardActions = KeyboardActions(
                        onAny = onImeAction
                    ),
                )
            }

            if (displayError) {
                when {
                    value.text.isBlank() -> {
                        emptyError?.let {
                            TextFieldError(it)
                        }
                    }

                    !isValid -> {
                        validationError?.let {
                            TextFieldError(it)
                        }
                    }
                }
            }
        }

        if (isReadOnly) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .alpha(0f)
                    .clickable(onClick = onClick)
            )
        }
    }
}
