package org.mobilenativefoundation.store.news.shared


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.tab.TabOptions
import me.tatarka.inject.annotations.Inject
import org.mobilenativefoundation.store.news.shared.lib.composableModel.compose.rememberComposableModel
import org.mobilenativefoundation.store.news.shared.lib.res.drawable.homeIcon
import org.mobilenativefoundation.store.news.shared.lib.res.values.homeScreenTitle
import org.mobilenativefoundation.store.news.shared.models.Feed
import org.mobilenativefoundation.store.news.shared.models.FeedModule

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
        Text("Error")
    }

    @Composable
    private fun LoadedView(feed: Feed) {
        LazyColumn {
            feed.modules.forEach { module ->
                item {
                    when (module) {
                        is FeedModule.EditorsPick -> TODO()
                        is FeedModule.ForYou -> TODO()
                        is FeedModule.TopStories.Global -> {
                            val topStoriesModule = TopStoriesModule()
                            topStoriesModule(module.scoop)
                        }

                        is FeedModule.TopStories.US -> {
                            val topStoriesModule = TopStoriesModule()
                            topStoriesModule(module.scoop)
                        }

                        is FeedModule.TopStories.Local -> {
                            val topStoriesModule = TopStoriesModule()
                            topStoriesModule(module.scoop)
                        }

                        is FeedModule.TopStories.Category -> {
                            val topStoriesModule = TopStoriesModule()
                            topStoriesModule(module.scoop)
                        }
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