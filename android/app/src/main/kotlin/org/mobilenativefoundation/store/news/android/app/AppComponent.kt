package org.mobilenativefoundation.store.news.android.app

import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@Component
abstract class AppComponent(
    @get:Provides val app: NewsApp,
) {
    companion object
}