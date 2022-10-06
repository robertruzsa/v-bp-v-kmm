package com.robertruzsa.vbpvkmm.android.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color
import com.robertruzsa.vbpvkmm.ui.BlueHex
import com.robertruzsa.vbpvkmm.ui.DarkBackgroundHex
import com.robertruzsa.vbpvkmm.ui.DarkSurfaceHex
import com.robertruzsa.vbpvkmm.ui.DarkTextHex
import com.robertruzsa.vbpvkmm.ui.LightGrayHex
import com.robertruzsa.vbpvkmm.ui.LightGrayVariantHex
import com.robertruzsa.vbpvkmm.ui.OrangeHex
import com.robertruzsa.vbpvkmm.ui.RedErrorDarkHex
import com.robertruzsa.vbpvkmm.ui.RedErrorLightHex

val BlueColor = Color(BlueHex)
val LightGrayColor = Color(LightGrayHex)
val RedErrorDark = Color(RedErrorDarkHex)
val RedErrorLight = Color(RedErrorLightHex)
val DarkBackgroundColor = Color(DarkBackgroundHex)
val DarkSurfaceColor = Color(DarkSurfaceHex)
val DarkTextColor = Color(DarkTextHex)
val OrangeColor = Color(OrangeHex)
val LightGrayVariantColor = Color(LightGrayVariantHex)

val LightColorPalette = lightColors(
    primary = BlueColor,
    onPrimary = Color.White,
    primaryVariant = Color.DarkGray,
    secondary = BlueColor,
    onSecondary = Color.White,
    background = LightGrayColor,
    onBackground = Color.Gray,
    surface = Color.White,
    onSurface = Color.Black,
    error = RedErrorDark,
    secondaryVariant = LightGrayVariantColor
)

val DarkColorPalette = darkColors(
    primary = OrangeColor,
    onPrimary = Color.Black,
    primaryVariant = Color.LightGray,
    secondary = OrangeColor,
    onSecondary = Color.Black,
    background = DarkBackgroundColor,
    onBackground = Color.Gray,
    surface = DarkSurfaceColor,
    onSurface = DarkTextColor,
    error = RedErrorLight,
    secondaryVariant = Color.Gray
)
