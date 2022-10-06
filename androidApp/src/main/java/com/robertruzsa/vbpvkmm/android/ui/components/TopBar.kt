package com.robertruzsa.vbpvkmm.android.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopBar(
    title: String,
    navigationIcon: ImageVector? = null,
    onNavigationIconClick: () -> Unit = {},
    actionIcon: ImageVector? = null,
    onActionIconClick: () -> Unit = {},
    elevation: Dp = 0.dp,
    titleFontSize: TextUnit = 24.sp
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.surface,
        elevation = elevation
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Row {
                navigationIcon?.let {
                    IconButton(
                        onClick = onNavigationIconClick
                    ) {
                        Icon(
                            imageVector = navigationIcon,
                            tint = MaterialTheme.colors.onSurface,
                            contentDescription = null
                        )
                    }
                }

                Text(
                    modifier = Modifier
                        .padding(
                            start = if (navigationIcon == null) {
                                LocalSpacing.current.spacing16dp
                            } else {
                                0.dp
                            }
                        )
                        .align(Alignment.CenterVertically),
                    text = title,
                    color = MaterialTheme.colors.onSurface,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = titleFontSize
                )
            }

            actionIcon?.let {
                IconButton(
                    onClick = onActionIconClick,
                    modifier = Modifier
                        .wrapContentWidth(Alignment.End)
                        .align(Alignment.CenterVertically)
                ) {
                    Icon(
                        tint = MaterialTheme.colors.secondary,
                        imageVector = actionIcon,
                        contentDescription = null
                    )
                }
            }
        }
    }
}
