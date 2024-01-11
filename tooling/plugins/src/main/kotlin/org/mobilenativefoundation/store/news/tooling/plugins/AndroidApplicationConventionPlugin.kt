package org.mobilenativefoundation.store.news.tooling.plugins

import org.mobilenativefoundation.store.news.tooling.extensions.FlavorDimension
import org.mobilenativefoundation.store.news.tooling.extensions.BuildFlavor
import org.mobilenativefoundation.store.news.tooling.extensions.BuildType
import org.mobilenativefoundation.store.news.tooling.extensions.Versions
import org.mobilenativefoundation.store.news.tooling.extensions.configureAndroid
import org.mobilenativefoundation.store.news.tooling.extensions.configureAndroidCompose
import org.mobilenativefoundation.store.news.tooling.extensions.configureFlavors
import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import java.util.*

class AndroidApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                defaultConfig {
                    targetSdk = Versions.TARGET_SDK
                    missingDimensionStrategy(
                        FlavorDimension.contentType.name,
                        BuildFlavor.demo.name
                    )
                }

                buildFeatures {
                    buildConfig = true
                }

                configureAndroid()
                configureAndroidCompose(this)
                configureFlavors(this)

                val localProperties = Properties()
                val localPropertiesFile = rootProject.file("local.properties")
                if (localPropertiesFile.exists()) {
                    localProperties.load(localPropertiesFile.inputStream())
                }

                val googleServerClientId = "GOOGLE_SERVER_CLIENT_ID"

                buildTypes {
                    getByName(BuildType.DEBUG.applicationIdSuffix) {
                        buildConfigField(
                            "String",
                            googleServerClientId,
                            "\"${localProperties[googleServerClientId] ?: ""}\""
                        )
                    }

                    getByName(BuildType.RELEASE.applicationIdSuffix) {
                        buildConfigField(
                            "String",
                            googleServerClientId,
                            "\"${localProperties[googleServerClientId] ?: ""}\""
                        )
                    }
                }
            }
        }
    }
}
