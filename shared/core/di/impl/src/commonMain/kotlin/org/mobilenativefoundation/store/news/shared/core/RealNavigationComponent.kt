package org.mobilenativefoundation.store.news.shared.core

import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides
import org.mobilenativefoundation.store.news.shared.HomeTabComponent
import org.mobilenativefoundation.store.news.shared.core.navigation.api.NavigationComponent
import org.mobilenativefoundation.store.news.shared.core.navigation.api.TabNavigator
import org.mobilenativefoundation.store.news.shared.core.navigation.impl.RealTabNavigator

@Component
abstract class RealNavigationComponent(
    @Component val homeTabComponent: HomeTabComponent
) : NavigationComponent {

    @Provides
    fun bindTabNavigator(impl: RealTabNavigator): TabNavigator = impl

    companion object
}