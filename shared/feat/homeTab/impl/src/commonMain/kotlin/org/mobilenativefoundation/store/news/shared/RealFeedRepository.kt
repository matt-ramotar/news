package org.mobilenativefoundation.store.news.shared


import kotlinx.coroutines.flow.first
import me.tatarka.inject.annotations.Inject
import org.mobilenativefoundation.store.news.shared.models.Feed
import org.mobilenativefoundation.store.news.shared.models.FeedRefreshStrategy
import org.mobilenativefoundation.store.news.shared.models.GetFeedArgs
import org.mobilenativefoundation.store.store5.StoreReadRequest

@Inject
class RealFeedRepository(private val store: FeedStore) : FeedRepository {

    override suspend fun getFeed(
        args: GetFeedArgs,
        refreshStrategy: FeedRefreshStrategy,
    ): Feed {
        val request = mapToStoreRequest(args, refreshStrategy)
        return store.stream(request).first { it.dataOrNull() != null }.requireData()
    }

    private fun mapToStoreRequest(
        args: GetFeedArgs,
        refreshStrategy: FeedRefreshStrategy
    ): StoreReadRequest<GetFeedArgs> {
        return when (refreshStrategy) {
            FeedRefreshStrategy.FORCE_REFRESH -> StoreReadRequest.fresh(args, fallBackToSourceOfTruth = true)
            FeedRefreshStrategy.CACHE_FIRST -> StoreReadRequest.cached(args, refresh = true)
            FeedRefreshStrategy.CACHE_ONLY -> StoreReadRequest.cached(args, refresh = false)
        }
    }
}