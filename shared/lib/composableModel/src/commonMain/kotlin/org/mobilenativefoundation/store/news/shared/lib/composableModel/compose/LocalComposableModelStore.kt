package org.mobilenativefoundation.store.news.shared.lib.composableModel.compose

import org.mobilenativefoundation.store.news.shared.lib.composableModel.ComposableModelStore
import androidx.compose.runtime.compositionLocalOf

val LocalComposableModelStore = compositionLocalOf<ComposableModelStore> {
    error("ComposableModelStore not provided.")
}