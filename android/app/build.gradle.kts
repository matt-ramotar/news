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
    implementation(libs.androidx.appCompat)
    implementation(libs.androidx.compose.activity)
    implementation(libs.androidx.core)
    implementation(libs.coroutines.android)
    implementation(libs.kotlinInject.runtime)
    implementation(libs.serialization.core)
    implementation(libs.serialization.json)
    implementation(libs.voyager.navigator)

    ksp(libs.kotlinInject.compiler)

    with(projects.shared.core) {
        implementation(navigation.impl)
        implementation(di.impl)
    }

    with(projects.shared.feat) {
        implementation(homeTab.impl)
    }

    with(projects.shared.lib) {
        implementation(composableModel)
        implementation(env)
        implementation(res)
        implementation(scoop)
        implementation(theme)
    }
}

ksp {
    arg("me.tatarka.inject.generateCompanionExtensions", "true")
}