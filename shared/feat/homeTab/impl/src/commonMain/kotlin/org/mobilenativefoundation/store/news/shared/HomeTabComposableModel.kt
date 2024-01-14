package org.mobilenativefoundation.store.news.shared


import kotlinx.coroutines.launch
import me.tatarka.inject.annotations.Inject
import org.mobilenativefoundation.store.news.shared.lib.composableModel.ComposableModel
import org.mobilenativefoundation.store.news.shared.models.CursorDirection
import org.mobilenativefoundation.store.news.shared.models.Feed
import org.mobilenativefoundation.store.news.shared.models.FeedRefreshStrategy
import org.mobilenativefoundation.store.news.shared.models.GetFeedArgs

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
            loadFeed(FeedRefreshStrategy.CACHE_FIRST) {
                setState { HomeTabState.Loading }
            }
        }
    }

    suspend fun refresh(state: HomeTabState.Loaded) {
        loadFeed(FeedRefreshStrategy.FORCE_REFRESH) {
            setState { HomeTabState.Refreshing(state.feed) }
        }
    }

    private fun defaultArgs() = GetFeedArgs(
        count = DEFAULT_COUNT,
        cursor = null,
        direction = CursorDirection.OLDER
    )

    private suspend fun loadFeed(
        refreshStrategy: FeedRefreshStrategy,
        args: GetFeedArgs = defaultArgs(),
        onLoad: () -> Unit
    ) {
        onLoad()

        try {
            val feed = feedRepository.getFeed(args, refreshStrategy)
            setState { HomeTabState.Loaded(feed) }
        } catch (error: Throwable) {
            setState { HomeTabState.Failed }
        }
    }
}