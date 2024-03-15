package org.mobilenativefoundation.store.news.shared.models

sealed interface FeedModule {
    sealed interface TopStories : FeedModule {
        data class Global(val scoop: Scoop) : FeedModule
        data class US(val scoop: Scoop) : FeedModule
        data class Local(val scoop: Scoop) : FeedModule
        data class Category(val scoop: Scoop) : FeedModule
    }

    data class EditorsPick(val scoop: Scoop) : FeedModule
    data class ForYou(val scoop: Scoop) : FeedModule
}