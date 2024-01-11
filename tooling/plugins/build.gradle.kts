plugins {
    `kotlin-dsl`
}

group = "org.mobilenativefoundation.store.news.tooling.plugins"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17

    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplicationPlugin") {
            id = "plugin.store.news.android.application"
            implementationClass = "org.mobilenativefoundation.store.tooling.plugins.AndroidApplicationConventionPlugin"
        }

        register("androidComposePlugin") {
            id = "plugin.store.news.android.compose"
            implementationClass = "org.mobilenativefoundation.store.tooling.plugins.AndroidComposeConventionPlugin"
        }

        register("androidLibraryPlugin") {
            id = "plugin.store.news.android.library"
            implementationClass = "org.mobilenativefoundation.store.tooling.plugins.AndroidLibraryConventionPlugin"
        }

        register("kotlinAndroidLibraryPlugin") {
            id = "plugin.store.news.kotlin.android.library"
            implementationClass = "org.mobilenativefoundation.store.tooling.plugins.KotlinAndroidLibraryConventionPlugin"
        }

        register("kotlinMultiplatformPlugin") {
            id = "plugin.store.news.kotlin.multiplatform"
            implementationClass = "org.mobilenativefoundation.store.tooling.plugins.KotlinMultiplatformConventionPlugin"
        }
    }
}
