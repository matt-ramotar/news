package org.mobilenativefoundation.store.news.shared

import ai.wandering.scoop.v1.models.Feed
import ai.wandering.scoop.v1.models.FeedModule
import ai.wandering.scoop.v1.models.TopStories
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.tab.TabOptions
import me.tatarka.inject.annotations.Inject
import org.mobilenativefoundation.store.news.shared.lib.composableModel.compose.rememberComposableModel
import org.mobilenativefoundation.store.news.shared.lib.res.drawable.homeIcon
import org.mobilenativefoundation.store.news.shared.lib.res.values.homeScreenTitle

@Inject
class RealHomeTab : HomeTab {
    @Composable
    override fun Content() {
        val composableModel = rememberComposableModel<HomeTabComposableModel>()

        val state = composableModel.state.collectAsState()

        when (val viewState = state.value) {
            HomeTabState.Initial -> InitialView()

            HomeTabState.Loading -> LoadingView()

            HomeTabState.Failed -> ErrorView()

            is HomeTabState.Loaded -> {
                val feed = viewState.feed
                LoadedView(feed)
            }

            is HomeTabState.Refreshing -> {
                val feed = viewState.feed

                Column {
                    RefreshingBanner()
                    LoadedView(feed)
                }
            }
        }
    }

    @Composable
    private fun RefreshingBanner() {
        TODO()
    }

    @Composable
    private fun InitialView() {
        // TODO(mramotar)
    }

    @Composable
    private fun LoadingView() {
        // TODO(mramotar)
    }

    @Composable
    private fun ErrorView() {
        // TODO(mramotar)
    }

    @Composable
    private fun LoadedView(feed: Feed) {
        LazyColumn {
            feed.modules.forEach { module ->
                item {
                    when (val feedModule = module.type) {
                        is FeedModule.Type.EditorsPick -> TODO()
                        is FeedModule.Type.ForYou -> TODO()
                        is FeedModule.Type.TopStories -> {
                            val topStoriesModule = TopStoriesModule()

                            when (val topStoriesFeedModule = feedModule.value.type) {
                                is TopStories.Type.Category -> {
                                    topStoriesFeedModule.value.scoop?.let { scoop ->
                                        topStoriesModule(scoop)
                                    }
                                }

                                is TopStories.Type.Global -> {
                                    topStoriesFeedModule.value.scoop?.let { scoop ->
                                        topStoriesModule(scoop)
                                    }
                                }

                                is TopStories.Type.Local -> {
                                    topStoriesFeedModule.value.scoop?.let { scoop ->
                                        topStoriesModule(scoop)
                                    }
                                }

                                is TopStories.Type.Us -> {
                                    topStoriesFeedModule.value.scoop?.let { scoop ->
                                        topStoriesModule(scoop)
                                    }
                                }

                                null -> ErrorView()
                            }
                        }

                        null -> ErrorView()
                    }
                }
            }
        }
    }

    override val options: TabOptions
        @Composable
        get() {
            val title = homeScreenTitle
            val icon = homeIcon

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon,
                )
            }
        }
}