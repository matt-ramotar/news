plugins {
    id("plugin.store.news.android.library")
    id("plugin.store.news.kotlin.multiplatform")
    alias(libs.plugins.compose)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(compose.runtime)
                api(libs.coroutines.core)
                implementation(libs.kotlinInject.runtime)
            }
        }
    }
}

android {
    namespace = "org.mobilenativefoundation.store.news.shared.lib.composableModel"
}