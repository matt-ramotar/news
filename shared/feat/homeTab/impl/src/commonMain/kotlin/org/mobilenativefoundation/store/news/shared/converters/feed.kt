package org.mobilenativefoundation.store.news.shared.converters

import org.mobilenativefoundation.store.news.shared.models.Cursor
import org.mobilenativefoundation.store.news.shared.models.CursorDirection
import org.mobilenativefoundation.store.news.shared.models.Feed
import org.mobilenativefoundation.store.news.shared.models.FeedMetadata
import org.mobilenativefoundation.store.news.shared.models.FeedModule
import org.mobilenativefoundation.store.news.shared.models.GetFeedArgs
import org.mobilenativefoundation.store.news.shared.models.PopulatedStory
import org.mobilenativefoundation.store.news.shared.models.Publication
import org.mobilenativefoundation.store.news.shared.models.Scoop
import org.mobilenativefoundation.store.news.shared.models.Story
import org.mobilenativefoundation.store.news.shared.models.StoryAssocs
import org.mobilenativefoundation.store.news.shared.models.Tag
import ai.wandering.scoop.v1.models.Cursor as NetworkCursor
import ai.wandering.scoop.v1.models.CursorDirection as NetworkCursorDirection
import ai.wandering.scoop.v1.models.Feed as NetworkFeed
import ai.wandering.scoop.v1.models.FeedMetadata as NetworkFeedMetadata
import ai.wandering.scoop.v1.models.FeedModule as NetworkFeedModule
import ai.wandering.scoop.v1.models.FeedModule.Type.EditorsPick as NetworkEditorsPick
import ai.wandering.scoop.v1.models.FeedModule.Type.ForYou as NetworkForYou
import ai.wandering.scoop.v1.models.FeedModule.Type.TopStories as NetworkTopStories
import ai.wandering.scoop.v1.models.GetFeedArgs as NetworkGetFeedArgs
import ai.wandering.scoop.v1.models.Scoop as NetworkScoop
import ai.wandering.scoop.v1.models.Story as NetworkStory


fun CursorDirection.toNetwork(): NetworkCursorDirection {
    TODO()
}

fun Cursor.toNetwork(): NetworkCursor {
    TODO()
}

fun NetworkFeed.toLocal(): Feed {
    return Feed(
        modules = modules.map { it.toLocal() },
        metadata = metadata!!.toLocal()
    )
}

fun GetFeedArgs.toNetwork(): NetworkGetFeedArgs {
    TODO()
}

fun NetworkFeedModule.toLocal(): FeedModule {
    return when (this.type) {
        is NetworkEditorsPick -> TODO()
        is NetworkForYou -> TODO()
        is NetworkTopStories -> FeedModule.TopStories.US(
            scoop = this.topStories!!.us!!.scoop!!.toLocal(),
        )

        null -> TODO()
    }
}

fun NetworkFeedMetadata.toLocal(): FeedMetadata {
    return FeedMetadata(
        cursor = cursor!!.toLocal(),
        totalCount = totalCount,
        isEndOfFeed = isEndOfFeed,
        lastUpdated = lastUpdated
    )
}

fun NetworkCursor.toLocal(): Cursor {
    return Cursor(
        id = id,
        timestamp = timestamp
    )
}

fun NetworkScoop.toLocal(): Scoop {
    return Scoop(
        stories = stories.map { it.toLocal() },
        title = title,
        summary = summary
    )
}

fun ai.wandering.scoop.v1.models.PopulatedStory.toLocal(): PopulatedStory {
    return PopulatedStory(
        story = story!!.toLocal(),
        assocs = assocs!!.toLocal()
    )
}

fun NetworkStory.toLocal(): Story {
    return Story(
        title = title,
    )
}

fun ai.wandering.scoop.v1.models.StoryAssocs.toLocal(): StoryAssocs {
    return StoryAssocs(
        tags = tags.map { it.toLocal() },
        publication = publication?.toLocal()
    )
}

fun ai.wandering.scoop.v1.models.Tag.toLocal(): Tag {
    return Tag(
        name = name
    )
}

fun ai.wandering.scoop.v1.models.Publication.toLocal(): Publication {
    return Publication(
        title = title,
        logoUrl = logoUrl
    )
}