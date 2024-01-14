package org.mobilenativefoundation.store.news.shared.models

data class Scoop(
    val stories: List<PopulatedStory>,
    val title: String,
    val summary: String,
)