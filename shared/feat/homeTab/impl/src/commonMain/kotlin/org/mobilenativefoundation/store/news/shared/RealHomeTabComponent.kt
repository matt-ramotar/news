package org.mobilenativefoundation.store.news.shared

import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@Component
abstract class RealHomeTabComponent : HomeTabComponent {
    @Provides
    fun bindFeedRepository(impl: RealFeedRepository): FeedRepository = impl

    @Provides
    fun bindHomeTab(impl: RealHomeTab): HomeTab = impl

    companion object
}