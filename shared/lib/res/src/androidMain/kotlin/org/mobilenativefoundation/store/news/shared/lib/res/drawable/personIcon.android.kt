package org.mobilenativefoundation.store.news.shared.lib.res.drawable

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import org.mobilenativefoundation.store.news.shared.lib.res.R

actual val personIcon: Painter
    @Composable
    get() {
        val resId = R.drawable.profile
        return painterResource(resId)
    }