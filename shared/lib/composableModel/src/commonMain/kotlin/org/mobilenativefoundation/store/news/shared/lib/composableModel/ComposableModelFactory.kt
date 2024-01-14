package org.mobilenativefoundation.store.news.shared.lib.composableModel

import kotlin.reflect.KClass

class ComposableModelFactory(val composableModelMap: Map<ComposableModelClassKey, ComposableModel<*>>) {
    inline fun <reified T : ComposableModel<*>> create(modelClass: KClass<T>): T {
        val composableModel = composableModelMap[modelClass]
        requireNotNull(composableModel) { "Unknown ComposableModel class $modelClass." }
        return composableModel as T
    }
}