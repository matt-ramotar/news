package org.mobilenativefoundation.store.news.shared.core.navigation.impl

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import me.tatarka.inject.annotations.Inject
import org.mobilenativefoundation.store.news.shared.core.navigation.api.TabNavigator
import org.mobilenativefoundation.store.news.shared.lib.res.drawable.homeIcon
import org.mobilenativefoundation.store.news.shared.lib.res.drawable.homeIconLight
import cafe.adriel.voyager.navigator.tab.TabNavigator as VoyagerTabNavigator


@Inject
class RealTabNavigator(
    private val homeTab: Tab
) : TabNavigator {
    @Composable
    override fun invoke() {
        VoyagerTabNavigator(homeTab) {
            Scaffold(
                content = {
                    Column(modifier = Modifier.padding(it)) {
                        CurrentTab()
                    }
                },
                bottomBar = {
                    BottomAppBar(
                        containerColor = MaterialTheme.colorScheme.background,
                        actions = {
                            BottomNavItem(homeTab)
                        }
                    )
                }
            )
        }
    }

    @Composable
    private fun BottomNavItem(tab: Tab) {
        val tabNavigator = LocalTabNavigator.current
        IconButton(onClick = { tabNavigator.current = tab }) {
            val icon = tab.icon(tabNavigator.current == tab)

            val tint = if (tabNavigator.current == tab) Color.Unspecified else MaterialTheme.colorScheme.onBackground

            Icon(painter = icon, contentDescription = tab.options.title, tint = tint)
        }
    }


    @Composable
    private fun Tab.icon(isSelected: Boolean): Painter {
        // TODO(mramotar)
        return if (isSelected) {
            homeIcon
        } else {
            homeIconLight
        }
    }
}
