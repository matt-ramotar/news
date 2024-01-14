package org.mobilenativefoundation.store.news.shared

import ai.wandering.scoop.v1.models.Feed
import ai.wandering.scoop.v1.models.GetFeedArgs

interface FeedRepository {
    suspend fun getFeed(args: GetFeedArgs): Feed
}