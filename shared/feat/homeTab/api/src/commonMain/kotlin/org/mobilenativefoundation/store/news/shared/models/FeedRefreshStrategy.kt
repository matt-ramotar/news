package org.mobilenativefoundation.store.news.shared.models

enum class FeedRefreshStrategy {
    FORCE_REFRESH, // Ignores cache and fetches fresh data
    CACHE_FIRST, // Returns cached data quickly, then updates if needed
    CACHE_ONLY, // Only returns cached data without fetching new data
}