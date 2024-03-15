package org.mobilenativefoundation.store.news.shared.models

data class Story(
    val title: String,
)

data class StoryAssocs(
    val tags: List<Tag>,
    val publication: Publication?
)

data class PopulatedStory(
    val story: Story,
    val assocs: StoryAssocs
)