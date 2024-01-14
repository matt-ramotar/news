package org.mobilenativefoundation.store.news.android.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import me.tatarka.inject.annotations.Inject
import org.mobilenativefoundation.store.news.shared.core.navigation.api.NavigationComponent
import org.mobilenativefoundation.store.news.shared.core.navigation.impl.RealNavigationComponent
import org.mobilenativefoundation.store.news.shared.core.navigation.impl.create

@Inject
class MainActivity : ComponentActivity() {
    private val navigationComponent: NavigationComponent by lazy {
        RealNavigationComponent::class.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            navigationComponent.tabNavigator()
        }
    }
}