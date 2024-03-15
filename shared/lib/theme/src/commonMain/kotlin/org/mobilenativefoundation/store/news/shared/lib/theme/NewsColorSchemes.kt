package org.mobilenativefoundation.store.news.shared.lib.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme

object NewsColorSchemes {
    val Light = lightColorScheme(
        primary = NewsColors.primary_500,
        onPrimary = NewsColors.white,
        primaryContainer = NewsColors.primary_100,
        onPrimaryContainer = NewsColors.primary_500,

        background = NewsColors.white,
        onBackground = NewsColors.dark_1,
        surface = NewsColors.grayscale_100,
        surfaceVariant = NewsColors.grayscale_100,
        surfaceTint = NewsColors.grayscale_100,
        onSurface = NewsColors.dark_1,
    )


    val Dark = darkColorScheme(
        primary = NewsColors.primary_500,
        onPrimary = NewsColors.dark_1,
        primaryContainer = NewsColors.primary_100,
        onPrimaryContainer = NewsColors.primary_500,

        background = NewsColors.dark_1,
        onBackground = NewsColors.white,
        surface = NewsColors.dark_2,
        surfaceVariant = NewsColors.dark_3,
        surfaceTint = NewsColors.dark_2,
        onSurface = NewsColors.white,
    )
}