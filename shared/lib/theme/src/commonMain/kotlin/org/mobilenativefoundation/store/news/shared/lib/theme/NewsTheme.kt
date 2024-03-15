package org.mobilenativefoundation.store.news.shared.lib.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun NewsTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colorScheme = if (useDarkTheme) NewsColorSchemes.Dark else NewsColorSchemes.Light

    MaterialTheme(
        colorScheme = colorScheme,
        typography = NewsTypography.Urbanist,
        content = content
    )
}
