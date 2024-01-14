package org.mobilenativefoundation.store.news.shared.core.navigation.impl

import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides
import org.mobilenativefoundation.store.news.shared.HomeTab
import org.mobilenativefoundation.store.news.shared.RealHomeTab
import org.mobilenativefoundation.store.news.shared.core.navigation.api.NavigationComponent
import org.mobilenativefoundation.store.news.shared.core.navigation.api.TabNavigator

@Component
abstract class RealNavigationComponent : NavigationComponent {
    @Provides
    fun bindHomeTab(impl: RealHomeTab): HomeTab = impl

    @Provides
    fun bindTabNavigator(impl: RealTabNavigator): TabNavigator = impl

    companion object
}