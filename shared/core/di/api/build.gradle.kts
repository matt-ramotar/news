plugins {
    id("plugin.store.news.android.library")
    id("plugin.store.news.kotlin.multiplatform")
    alias(libs.plugins.serialization)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
            }
        }
    }
}

android {
    namespace = "org.mobilenativefoundation.store.news.shared.core.di.api"
}