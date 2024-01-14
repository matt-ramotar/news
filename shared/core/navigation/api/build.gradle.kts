plugins {
    id("plugin.store.news.android.library")
    id("plugin.store.news.kotlin.multiplatform")
    alias(libs.plugins.serialization)
    alias(libs.plugins.compose)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.runtime)
            }
        }
    }
}

android {
    namespace = "org.mobilenativefoundation.store.news.shared.core.navigation.api"
}