package com.robertruzsa.vbpvkmm.android.ui.components.horizontaldatepicker

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.robertruzsa.vbpvkmm.android.ui.components.LocalSpacing

@Preview
@Composable
fun HorizontalDateItem(
    dateString: String = "Ma",
    isSelected: Boolean = true,
    onDateClick: () -> Unit = {}
) {
    val fontWeight: FontWeight
    val fontColor: Color
    if (isSelected) {
        fontWeight = FontWeight.SemiBold
        fontColor = MaterialTheme.colors.primary
    } else {
        fontWeight = FontWeight.Normal
        fontColor = MaterialTheme.colors.onSurface
    }
    Column(
        modifier = Modifier
            .clickable {
                onDateClick.invoke()
            }
            .width(IntrinsicSize.Max),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(horizontal = LocalSpacing.current.spacing8dp),
            text = dateString,
            color = fontColor,
            fontWeight = fontWeight,
            textAlign = TextAlign.Center
        )
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = if (isSelected) {
                MaterialTheme.colors.primary
            } else {
                MaterialTheme.colors.surface
            },
            thickness = 2.dp
        )
    }
}
