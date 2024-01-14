package org.mobilenativefoundation.store.news.shared

import ai.wandering.scoop.v1.models.PopulatedStory
import ai.wandering.scoop.v1.models.Scoop
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

class TopStoriesModule {
    @Composable
    operator fun invoke(scoop: Scoop, modifier: Modifier = Modifier) {
        Column(modifier = Modifier.clip(RoundedCornerShape(8.dp)).then(modifier)) {
            Text("Top Stories")

            Column {
                coverImageUrlOrNull(scoop)?.let { url ->
                    AsyncImage(
                        model = url,
                        contentDescription = null,
                    )
                }

                BreakingNewsBanner(modifier = Modifier.fillMaxWidth().background(Color.Red).padding(8.dp))

                MainHeadline(modifier = Modifier.fillMaxWidth().padding(8.dp), scoop = scoop)

                Divider()

                scoop.stories.forEach { story ->
                    SubStory(story)
                    Divider()
                }

            }

            Divider(modifier = Modifier.fillMaxWidth())

            Text(latestUpdateAsFormattedString(scoop))
        }
    }

    @Composable
    private fun BreakingNewsBanner(modifier: Modifier = Modifier) {
        Row(modifier = modifier) {
            Text("Breaking")
        }
    }

    @Composable
    private fun MainHeadline(scoop: Scoop, modifier: Modifier = Modifier) {
        Row(modifier = modifier) {
            Text(scoop.title)
            Text(scoop.summary)
        }
    }

    @Composable
    private fun SubStory(populatedStory: PopulatedStory, modifier: Modifier = Modifier) {
        Row(modifier = modifier) {
            populatedStory.assocs?.publication?.logoUrl?.let { url ->
                AsyncImage(model = url, contentDescription = null)
            }

            Text(populatedStory.story!!.title)
        }
    }

    @Composable
    private fun Divider(modifier: Modifier = Modifier) {
        Row(modifier = Modifier.height(1.dp).fillMaxWidth().then(modifier)) {
        }
    }

    private fun coverImageUrlOrNull(scoop: Scoop): String? {
        // TODO(mramotar)
        return ""
    }

    private fun latestUpdateAsFormattedString(scoop: Scoop): String {
        // TODO(mramotar)
        return "1h ago"
    }
}