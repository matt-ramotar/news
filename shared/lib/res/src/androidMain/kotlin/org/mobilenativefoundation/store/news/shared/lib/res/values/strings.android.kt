package org.mobilenativefoundation.store.news.shared.lib.res.values

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import org.mobilenativefoundation.store.news.shared.lib.res.R

actual val homeScreenTitle: String
    @Composable
    get() {
        val resId = R.string.home_screen_title
        return stringResource(resId)
    }
actual val homeIconDescription: String
    @Composable
    get() {
        val resId = R.string.home_icon_description
        return stringResource(resId)
    }
actual val discoverScreenTitle: String
    @Composable
    get() {
        val resId = R.string.discover_screen_title
        return stringResource(resId)
    }
actual val discoveryIconDescription: String
    @Composable
    get() {
        val resId = R.string.discover_screen_title
        return stringResource(resId)
    }
actual val accountScreenTitle: String
    @Composable
    get() {
        val resId = R.string.account_screen_title
        return stringResource(resId)
    }