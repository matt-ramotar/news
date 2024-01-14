package org.mobilenativefoundation.store.news.shared

import ai.wandering.scoop.v1.models.CursorDirection
import ai.wandering.scoop.v1.models.Feed
import ai.wandering.scoop.v1.models.GetFeedArgs
import kotlinx.coroutines.launch
import me.tatarka.inject.annotations.Inject
import org.mobilenativefoundation.store.news.shared.lib.composableModel.ComposableModel

sealed interface HomeTabState {
    data object Initial : HomeTabState
    data object Loading : HomeTabState
    data class Loaded(val feed: Feed) : HomeTabState
    data class Refreshing(val feed: Feed) : HomeTabState
    data object Failed : HomeTabState
}

@Inject
class HomeTabComposableModel(
    private val feedRepository: FeedRepository
) : ComposableModel<HomeTabState>(HomeTabState.Initial) {

    companion object {
        private const val DEFAULT_COUNT = 10
    }

    init {
        coroutineScope.launch {
            loadFeed {
                setState { HomeTabState.Loading }
            }
        }
    }

    suspend fun refresh(state: HomeTabState.Loaded) {
        loadFeed {
            setState { HomeTabState.Refreshing(state.feed) }
        }
    }

    private fun defaultArgs() = GetFeedArgs(
        count = DEFAULT_COUNT,
        cursor = null,
        direction = CursorDirection.OLDER
    )

    private suspend fun loadFeed(args: GetFeedArgs = defaultArgs(), onLoad: () -> Unit) {
        onLoad()

        try {
            val feed = feedRepository.getFeed(args)
            setState { HomeTabState.Loaded(feed) }
        } catch (error: Throwable) {
            setState { HomeTabState.Failed }
        }
    }
}