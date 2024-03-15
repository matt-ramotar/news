package org.mobilenativefoundation.store.news.shared.models

data class GetFeedArgs(
    val count: Int,
    val direction: CursorDirection,
    val cursor: Cursor?,
)