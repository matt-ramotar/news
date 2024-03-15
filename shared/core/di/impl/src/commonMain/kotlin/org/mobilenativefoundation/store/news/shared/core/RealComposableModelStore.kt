package org.mobilenativefoundation.store.news.shared.core


import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.IntoMap
import me.tatarka.inject.annotations.Provides
import org.mobilenativefoundation.store.news.shared.FeedRepository
import org.mobilenativefoundation.store.news.shared.HomeTabComponent
import org.mobilenativefoundation.store.news.shared.HomeTabComposableModel
import org.mobilenativefoundation.store.news.shared.lib.composableModel.ComposableModel
import org.mobilenativefoundation.store.news.shared.lib.composableModel.ComposableModelClassKey
import org.mobilenativefoundation.store.news.shared.lib.composableModel.ComposableModelStore


@Component
abstract class RealComposableModelStore(
    @Component val homeTabComponent: HomeTabComponent,
) : ComposableModelStore {
    abstract override val map: Map<ComposableModelClassKey, ComposableModel<*>>

    @IntoMap
    @Provides
    fun provideHomeTabComposableModel(
        feedRepository: FeedRepository
    ): Pair<ComposableModelClassKey, ComposableModel<*>> =
        HomeTabComposableModel::class to HomeTabComposableModel(feedRepository)

    companion object
}