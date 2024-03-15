package org.mobilenativefoundation.store.news.shared.lib.theme

import androidx.compose.ui.graphics.Color

object NewsColors {
    val primary_500 = Color(240, 65, 73)
    val primary_400 = primary_500.copy(alpha = 0.8f)
    val primary_300 = primary_500.copy(alpha = 0.6f)
    val primary_200 = primary_500.copy(alpha = 0.4f)
    val primary_100 = primary_500.copy(alpha = 0.2f)

    val grayscale_900 = Color(0xFF212121)
    val grayscale_800 = Color(0xFF424242)
    val grayscale_700 = Color(0xFF616161)
    val grayscale_600 = Color(0xFF757575)
    val grayscale_500 = Color(0xFF9E9E9E)
    val grayscale_400 = Color(0xFFBDBDBD)
    val grayscale_300 = Color(0xFFE0E0E0)
    val grayscale_200 = Color(0xFFEEEEEE)
    val grayscale_100 = Color(0xFFF5F5F5)
    val grayscale_50 = Color(0xFFFAFAFA)

    val dark_1 = Color(0xFF181A20)
    val dark_2 = Color(0xFF1F222A)
    val dark_3 = Color(0xFF35383F)

    val background_red = Color(0xFFFFF1F3)

    val transparent_red = primary_500.copy(alpha = 0.08f)

    val white = Color(0xFFFFFFFF)
    val black = Color(0xFF000000)
}

