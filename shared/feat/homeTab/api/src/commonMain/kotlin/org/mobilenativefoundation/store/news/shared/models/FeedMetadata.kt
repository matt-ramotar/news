package org.mobilenativefoundation.store.news.shared.models

data class FeedMetadata(
    val cursor: Cursor, // Current position in the feed
    val totalCount: Int, // Total count of items in the entire feed, if known
    val isEndOfFeed: Boolean, // Indicator if the end of the feed has been reached
    val lastUpdated: Long, // Timestamp of the last update to the feed
)