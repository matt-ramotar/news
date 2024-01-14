
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
                implementation(libs.coroutines.core)
                implementation(libs.kotlinInject.runtime)
                implementation(libs.voyager.tabNavigator)
                implementation(libs.voyager.screenModel)

                api(projects.shared.core.navigation.api)
                implementation(projects.shared.lib.res)
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
    namespace = "org.mobilenativefoundation.store.news.shared.core.navigation.impl"
}