package com.example.musicbandsapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = primaryDarkColor,
    onPrimary = Color.Black,
    secondary = secondaryDarkColor,
    onSecondary = Color.Black
)

private val LightColorPalette = lightColors(
    primary = primaryLightColor,
    onPrimary = primaryTextColor,
    secondary = secondaryLightColor,
    onSecondary = secondaryTextColor,
    background = Color.Transparent,
    onBackground = Color.White,
    onSurface = primaryColor
)

@Composable
fun MusicBandsAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}