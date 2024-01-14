plugins {
    id("plugin.store.news.android.application")
    alias(libs.plugins.ksp)
    alias(libs.plugins.compose)
}

android {
    namespace = "org.mobilenativefoundation.store.news.android.app"

    defaultConfig {
        applicationId = "org.mobilenativefoundation.store.news"
        versionCode = 1
        versionName = "1.0"
    }

    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
            excludes.add("/META-INF/versions/9/previous-compilation-data.bin")
        }
    }
}

dependencies {
    implementation(compose.runtime)
    implementation(compose.material3)

    implementation(libs.coroutines.android)
    implementation(libs.serialization.core)
    implementation(libs.serialization.json)

    implementation(libs.androidx.appCompat)
    implementation(libs.androidx.compose.activity)
    implementation(libs.androidx.core)

    implementation(libs.kotlinInject.runtime)
    ksp(libs.kotlinInject.compiler)

    implementation(libs.voyager.navigator)

//    implementation(projects.shared.lib.skeleton)
//    implementation(projects.shared.lib.theme)
//    implementation(projects.shared.lib.composableModel)
//    implementation(projects.shared.lib.sdk.v1)
//    implementation(projects.shared.lib.res)
//
//    implementation(projects.shared.core.impl)
//    implementation(projects.shared.feat.auth.impl)
//    implementation(projects.shared.feat.splash.impl)
}

ksp {
    arg("me.tatarka.inject.generateCompanionExtensions", "true")
}