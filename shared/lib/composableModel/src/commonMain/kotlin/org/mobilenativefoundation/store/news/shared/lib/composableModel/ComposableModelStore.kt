package org.mobilenativefoundation.store.news.shared.lib.composableModel

import kotlin.jvm.JvmSuppressWildcards

interface ComposableModelStore {
    val map: Map<ComposableModelClassKey, @JvmSuppressWildcards ComposableModel<*>>
}