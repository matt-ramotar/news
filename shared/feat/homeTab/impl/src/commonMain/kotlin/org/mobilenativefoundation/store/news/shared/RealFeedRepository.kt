package org.mobilenativefoundation.store.news.shared

import ai.wandering.scoop.v1.models.Feed
import ai.wandering.scoop.v1.models.GetFeedArgs
import me.tatarka.inject.annotations.Inject

@Inject
class RealFeedRepository: FeedRepository {
    override suspend fun getFeed(args: GetFeedArgs): Feed {
        TODO("Not yet implemented")
    }
}