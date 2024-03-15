package org.mobilenativefoundation.store.news.shared.lib.composableModel.compose

import org.mobilenativefoundation.store.news.shared.lib.composableModel.ComposableModel
import org.mobilenativefoundation.store.news.shared.lib.composableModel.ComposableModelFactory
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlin.reflect.KClass

@Composable
inline fun <reified T : ComposableModel<*>> composableModel(modelClass: KClass<T>): T {
    val store = LocalComposableModelStore.current
    val factory = ComposableModelFactory(store.map)
    return remember { factory.create(modelClass) }
}