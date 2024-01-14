
plugins {
    id("plugin.store.news.android.library")
    id("plugin.store.news.kotlin.multiplatform")
    alias(libs.plugins.serialization)
    alias(libs.plugins.ksp)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlinInject.runtime)
                api(libs.scoop.sdk.kotlin)
                api(projects.shared.lib.httpClient)
                implementation(projects.shared.lib.env)
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
    namespace = "org.mobilenativefoundation.store.news.shared.lib.scoop"
}