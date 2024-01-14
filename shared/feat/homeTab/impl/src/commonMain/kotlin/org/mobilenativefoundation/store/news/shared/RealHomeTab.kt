package org.mobilenativefoundation.store.news.shared

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.tab.TabOptions
import me.tatarka.inject.annotations.Inject
import org.mobilenativefoundation.store.news.shared.lib.res.drawable.homeIcon
import org.mobilenativefoundation.store.news.shared.lib.res.values.homeScreenTitle

@Inject
class RealHomeTab : HomeTab {
    @Composable
    override fun Content() {
        Text(homeScreenTitle)
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