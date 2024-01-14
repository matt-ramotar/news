package org.mobilenativefoundation.store.news.shared.lib.res.drawable

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import org.mobilenativefoundation.store.news.shared.lib.res.R

actual val discoveryIcon: Painter
    @Composable
    get() {
        val resId = R.drawable.discovery
        return painterResource(resId)
    }