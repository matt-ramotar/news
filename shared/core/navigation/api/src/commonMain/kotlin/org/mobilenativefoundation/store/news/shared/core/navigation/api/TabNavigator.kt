package org.mobilenativefoundation.store.news.shared.core.navigation.api

import androidx.compose.runtime.Composable

interface TabNavigator {
    @Composable
    operator fun invoke()
}
