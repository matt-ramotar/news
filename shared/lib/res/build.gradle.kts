
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
                implementation(compose.material3)
                implementation(libs.coroutines.core)
                implementation(libs.kotlinInject.runtime)
            }
        }
    }
}

android {
    namespace = "org.mobilenativefoundation.store.news.shared.lib.res"
}