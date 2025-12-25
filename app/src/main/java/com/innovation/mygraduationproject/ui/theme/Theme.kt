package com.innovation.mygraduationproject.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColors = darkColorScheme(
    primary = PalmBrown,
    secondary = DateBrown,
    background = BackgroundDark,
    surface = SurfaceDark,
    onPrimary = GoldSand,
    onSecondary = GoldSand,
    onBackground = TextPrimary,
    onSurface = TextPrimary
)
@Composable
fun TamrahTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColors,
        typography = TamrahTypography,
        content = content
    )
}