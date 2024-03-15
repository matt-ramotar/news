package org.mobilenativefoundation.store.news.shared

import ai.wandering.scoop.v1.ScoopClient
import ai.wandering.scoop.v1.models.Cursor
import ai.wandering.scoop.v1.models.FeedModule
import ai.wandering.scoop.v1.models.Scoop
import ai.wandering.scoop.v1.models.TopStories
import ai.wandering.scoop.v1.models.US
import kotlinx.coroutines.flow.flowOf
import me.tatarka.inject.annotations.Inject
import org.mobilenativefoundation.store.cache5.CacheBuilder
import org.mobilenativefoundation.store.news.shared.converters.toLocal
import org.mobilenativefoundation.store.news.shared.models.Feed
import org.mobilenativefoundation.store.news.shared.models.GetFeedArgs
import org.mobilenativefoundation.store.store5.Fetcher
import org.mobilenativefoundation.store.store5.SourceOfTruth
import org.mobilenativefoundation.store.store5.Store
import org.mobilenativefoundation.store.store5.StoreBuilder
import ai.wandering.scoop.v1.models.Feed as NetworkFeed

typealias FeedStore = Store<GetFeedArgs, Feed>

interface FeedStoreFactory {
    fun create(): FeedStore
}

@Inject
class RealFeedStoreFactory(
    private val scoopClient: ScoopClient
) : FeedStoreFactory {
    override fun create(): FeedStore {

        val fetcher = Fetcher.of<GetFeedArgs, NetworkFeed> { args ->
            // val response = scoopClient.getFeed(args.toNetwork())
            NetworkFeed(
                modules = listOf(
                    FeedModule(
                        type = FeedModule.Type.TopStories(
                            topStories = TopStories(
                                type = TopStories.Type.Us(
                                    us = US(
                                        id = "id",
                                        timestamp = 1L,
                                        scoop = Scoop(
                                            stories = listOf(),
                                            title = "Title",
                                            summary = "Summary"
                                        ),
                                    )
                                )
                            )
                        )
                    ),
                ),
                metadata = ai.wandering.scoop.v1.models.FeedMetadata(
                    cursor = Cursor("", 100L),
                    totalCount = 100,
                    isEndOfFeed = false,
                    lastUpdated = 1000L
                )
            )
        }

        val db = mutableMapOf<GetFeedArgs, Feed>()

        val sourceOfTruth = SourceOfTruth.of<GetFeedArgs, NetworkFeed, Feed>(
            reader = { args ->
                flowOf(db[args])
            },
            writer = { args, feed ->
                db[args] = feed.toLocal()
            }
        )

        val memoryCache = CacheBuilder<GetFeedArgs, Feed>().build()

        return StoreBuilder.from(
            fetcher = fetcher,
            sourceOfTruth = sourceOfTruth,
            memoryCache = memoryCache
        ).build()
    }
}