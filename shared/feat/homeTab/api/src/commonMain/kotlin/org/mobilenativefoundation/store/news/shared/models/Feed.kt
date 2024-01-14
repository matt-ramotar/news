package org.mobilenativefoundation.store.news.shared.models

data class Feed(
    val modules: List<FeedModule>,
    val metadata: FeedMetadata
)

