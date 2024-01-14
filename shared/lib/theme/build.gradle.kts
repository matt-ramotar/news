plugins {
    id("plugin.store.news.android.library")
    id("plugin.store.news.kotlin.multiplatform")
    alias(libs.plugins.compose)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(compose.material3)
                implementation(projects.shared.lib.res)
            }
        }
    }
}

android {
    namespace = "org.mobilenativefoundation.store.news.shared.lib.theme"
}