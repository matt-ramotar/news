package org.mobilenativefoundation.store.news.shared

import ai.wandering.scoop.v1.ScoopClient
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides
import org.mobilenativefoundation.store.news.shared.lib.scoop.scoopClient

@Component
abstract class RealHomeTabComponent : HomeTabComponent {

    @Provides
    fun provideScoopClient(): ScoopClient = scoopClient()

    @Provides
    fun bindFeedStoreFactory(impl: RealFeedStoreFactory): FeedStoreFactory = impl

    @Provides
    fun provideFeedStore(feedStoreFactory: FeedStoreFactory): FeedStore = feedStoreFactory.create()

    @Provides
    fun bindFeedRepository(impl: RealFeedRepository): FeedRepository = impl

    @Provides
    fun bindHomeTab(impl: RealHomeTab): HomeTab = impl

    companion object
}