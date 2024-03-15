package org.mobilenativefoundation.store.news.shared


import org.mobilenativefoundation.store.news.shared.models.Feed
import org.mobilenativefoundation.store.news.shared.models.FeedRefreshStrategy
import org.mobilenativefoundation.store.news.shared.models.GetFeedArgs

interface FeedRepository {
    suspend fun getFeed(
        args: GetFeedArgs,
        refreshStrategy: FeedRefreshStrategy,
    ): Feed
}