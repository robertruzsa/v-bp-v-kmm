package com.robertruzsa.vbpvkmm.android.ui.components

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Spacing(
    val spacing4dp: Dp = 4.dp,
    val spacing8dp: Dp = 8.dp,
    val spacing16dp: Dp = 16.dp,
    val spacing24dp: Dp = 24.dp,
    val spacing32dp: Dp = 32.dp,
)

val LocalSpacing = compositionLocalOf { Spacing() }
