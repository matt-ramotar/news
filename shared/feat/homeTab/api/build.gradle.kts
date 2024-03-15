plugins {
    id("plugin.store.news.android.library")
    id("plugin.store.news.kotlin.multiplatform")
    alias(libs.plugins.serialization)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.voyager.tabNavigator)
            }
        }
    }
}

android {
    namespace = "org.mobilenativefoundation.store.news.shared.feat.homeTab.api"
}