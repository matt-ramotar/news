
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
                implementation(libs.scoop.sdk.kotlin)
                api(projects.shared.core.navigation.api)
                implementation(libs.ktor.core)
                implementation(libs.ktor.negotiation)
                implementation(libs.ktor.serialization.json)
            }
        }

        androidMain {
            dependencies {
                implementation("io.ktor:ktor-client-okhttp-jvm:2.3.7")
            }
        }
        nativeMain {
            dependencies {
                implementation("io.ktor:ktor-client-darwin:2.3.7")
            }
        }
        jvmMain {
            dependencies {
                implementation("io.ktor:ktor-client-apache5:2.3.7")
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
    namespace = "org.mobilenativefoundation.store.news.shared.lib.httpClient"
}