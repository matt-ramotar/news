package org.mobilenativefoundation.store.news.shared.lib.res.font

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import org.mobilenativefoundation.store.news.shared.lib.res.R

val urbanistFonts = listOf(
    Font(R.font.urbanist_black),
    Font(R.font.urbanist_black_italic),
    Font(R.font.urbanist_bold_italic),
    Font(R.font.urbanist_extra_bold),
    Font(R.font.urbanist_extra_bold_italic),
    Font(R.font.urbanist_extra_light),
    Font(R.font.urbanist_extra_light_italic),
    Font(R.font.urbanist_italic),
    Font(R.font.urbanist_light),
    Font(R.font.urbanist_light_italic),
    Font(R.font.urbanist_medium),
    Font(R.font.urbanist_medium_italic),
    Font(R.font.urbanist_regular),
    Font(R.font.urbanist_semi_bold),
    Font(R.font.urbanist_semi_bold_italic),
    Font(R.font.urbanist_thin),
    Font(R.font.urbanist_thin_italic),
)

actual val urbanistFontFamily: FontFamily = FontFamily(urbanistFonts)