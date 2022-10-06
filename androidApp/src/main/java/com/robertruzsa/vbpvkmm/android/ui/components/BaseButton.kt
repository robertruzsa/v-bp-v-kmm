package com.robertruzsa.vbpvkmm.android.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun BaseButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(50)
    ) {
        Text(
            modifier = Modifier.padding(
                vertical = LocalSpacing.current.spacing8dp,
                horizontal = LocalSpacing.current.spacing24dp
            ),
            text = text,
            fontSize = 16.sp
        )
    }
}
