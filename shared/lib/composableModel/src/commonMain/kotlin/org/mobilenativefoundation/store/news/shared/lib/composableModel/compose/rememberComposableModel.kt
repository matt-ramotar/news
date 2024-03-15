package org.mobilenativefoundation.store.news.shared.lib.composableModel.compose

import org.mobilenativefoundation.store.news.shared.lib.composableModel.ComposableModel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
inline fun <reified T : ComposableModel<*>> rememberComposableModel(): T {
    val model = composableModel(T::class)
    return remember(T::class) {
        model
    }
}