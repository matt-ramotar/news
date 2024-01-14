package org.mobilenativefoundation.store.news.shared.lib.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.mobilenativefoundation.store.news.shared.lib.res.font.urbanistFontFamily

object NewsTypography {
    val Urbanist = Typography(
        headlineLarge = TextStyle(
            fontFamily = urbanistFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 48.sp
        ),

        headlineMedium = TextStyle(
            fontFamily = urbanistFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp
        ),

        headlineSmall = TextStyle(
            fontFamily = urbanistFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp
        ),

        titleLarge = TextStyle(
            fontFamily = urbanistFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        ),

        titleMedium = TextStyle(
            fontFamily = urbanistFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        ),

        titleSmall = TextStyle(
            fontFamily = urbanistFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        ),

        bodyLarge = TextStyle(
            fontFamily = urbanistFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ),

        bodyMedium = TextStyle(
            fontFamily = urbanistFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        ),

        bodySmall = TextStyle(
            fontFamily = urbanistFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        )
    )
}
