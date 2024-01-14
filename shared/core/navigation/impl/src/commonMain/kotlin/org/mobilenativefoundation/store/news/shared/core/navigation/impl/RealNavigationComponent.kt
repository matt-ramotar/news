package org.mobilenativefoundation.store.news.shared.core.navigation.impl

import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides
import org.mobilenativefoundation.store.news.shared.core.navigation.api.NavigationComponent
import org.mobilenativefoundation.store.news.shared.core.navigation.api.TabNavigator

@Component
abstract class RealNavigationComponent : NavigationComponent {
    @Provides
    fun bindTabNavigator(impl: RealTabNavigator): TabNavigator = impl

    companion object
}