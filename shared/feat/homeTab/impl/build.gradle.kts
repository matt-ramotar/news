
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
                implementation(compose.material3)
                implementation(libs.coil)
                implementation(libs.coil.compose)
                implementation(libs.coil.network)
                implementation(libs.coroutines.core)
                implementation(libs.kotlinInject.runtime)
                implementation(libs.voyager.tabNavigator)

                api(projects.shared.core.navigation.api)
                api(projects.shared.feat.homeTab.api)
                implementation(projects.shared.lib.httpClient)
                implementation(projects.shared.lib.scoop)
                implementation(projects.shared.lib.res)
                implementation(projects.shared.lib.composableModel)
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