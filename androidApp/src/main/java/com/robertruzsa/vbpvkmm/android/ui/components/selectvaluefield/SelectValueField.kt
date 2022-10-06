package com.robertruzsa.vbpvkmm.android.ui.components.selectvaluefield

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.robertruzsa.vbpvkmm.android.ui.components.LocalSpacing

@Composable
fun SelectValueField(
    modifier: Modifier = Modifier,
    label: String = "",
    value: String = "",
    startIcon: ImageVector? = null,
    isValueSelected: Boolean = false,
    onClick: () -> Unit = {},
    elevation: Dp = 0.dp,
) {
    Card(
        modifier = modifier,
        shape = RectangleShape,
        elevation = elevation
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colors.surface)
                .clickable {
                    onClick.invoke()
                }
                .padding(LocalSpacing.current.spacing16dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                startIcon?.let {
                    Icon(
                        tint = MaterialTheme.colors.primaryVariant,
                        modifier = Modifier
                            .padding(end = LocalSpacing.current.spacing16dp),
                        imageVector = it,
                        contentDescription = null
                    )
                }
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = label,
                        style = MaterialTheme.typography.subtitle1.copy(
                            fontSize = if (isValueSelected) {
                                14.sp
                            } else {
                                16.sp
                            },
                            color = if (isValueSelected) {
                                MaterialTheme.colors.onBackground
                            } else {
                                MaterialTheme.colors.onSurface
                            }
                        )
                    )
                    if (isValueSelected) {
                        Text(
                            text = value,
                            style = MaterialTheme.typography.subtitle1.copy(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Normal,
                                color = MaterialTheme.colors.onSurface
                            )
                        )
                    }
                }
                Icon(
                    tint = MaterialTheme.colors.secondaryVariant,
                    imageVector = Icons.Filled.ChevronRight,
                    contentDescription = null
                )
            }
        }
    }
}
