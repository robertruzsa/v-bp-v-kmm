package com.robertruzsa.vbpvkmm.android.ui.components.textfield

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.robertruzsa.vbpvkmm.android.ui.components.LocalSpacing

@Composable
fun TextFieldError(textError: String) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.width(LocalSpacing.current.spacing16dp))
        Text(
            text = textError,
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.caption.copy(color = MaterialTheme.colors.error)
        )
    }
}
