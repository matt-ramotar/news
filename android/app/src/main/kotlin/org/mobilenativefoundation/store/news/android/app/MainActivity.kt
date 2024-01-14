package org.mobilenativefoundation.store.news.android.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import me.tatarka.inject.annotations.Inject
import org.mobilenativefoundation.store.news.shared.HomeTabComponent
import org.mobilenativefoundation.store.news.shared.RealHomeTabComponent
import org.mobilenativefoundation.store.news.shared.core.RealComposableModelStore
import org.mobilenativefoundation.store.news.shared.core.RealNavigationComponent
import org.mobilenativefoundation.store.news.shared.core.create
import org.mobilenativefoundation.store.news.shared.core.navigation.api.NavigationComponent
import org.mobilenativefoundation.store.news.shared.create
import org.mobilenativefoundation.store.news.shared.lib.composableModel.ComposableModelStore
import org.mobilenativefoundation.store.news.shared.lib.composableModel.compose.LocalComposableModelStore

@Inject
class MainActivity : ComponentActivity() {
    private val homeTabComponent: HomeTabComponent by lazy {
        RealHomeTabComponent::class.create()
    }

    private val navigationComponent: NavigationComponent by lazy {
        RealNavigationComponent::class.create(homeTabComponent)
    }

    private val composableModelStore: ComposableModelStore by lazy {
        RealComposableModelStore::class.create(homeTabComponent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CompositionLocalProvider(LocalComposableModelStore provides composableModelStore) {
                navigationComponent.tabNavigator()
            }
        }
    }
}