
plugins {
    id("plugin.store.news.android.library")
    id("plugin.store.news.kotlin.multiplatform")
    alias(libs.plugins.serialization)
    alias(libs.plugins.compose)
    alias(libs.plugins.ksp)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlinInject.runtime)
                api(projects.shared.core.navigation.api)
                implementation(projects.shared.lib.scoop)
            }
        }

        androidMain {
            dependencies {
            }
        }
    }
}

dependencies {
    add("kspAndroid", libs.kotlinInject.compiler)
    add("kspIosX64", libs.kotlinInject.compiler)
    add("kspIosArm64", libs.kotlinInject.compiler)
}

android {
    namespace = "org.mobilenativefoundation.store.news.shared.feat.homeTab.impl"
}