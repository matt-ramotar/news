package org.mobilenativefoundation.store.news.shared.lib.composableModel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class ComposableModel<State : Any>(initialState: State) {
    private val mutableStateFlow = MutableStateFlow(initialState)
    val state: StateFlow<State> = mutableStateFlow.asStateFlow()

    protected val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO)

    protected fun withState(block: (state: State) -> Unit) {
        block(mutableStateFlow.value)
    }

    protected fun setState(factory: () -> State) {
        mutableStateFlow.value = factory()
    }
}
