package org.mobilenativefoundation.store.news.tooling.plugins

import com.android.build.gradle.LibraryExtension
import org.mobilenativefoundation.store.news.tooling.extensions.Versions
import org.mobilenativefoundation.store.news.tooling.extensions.configureAndroidCompose
import org.mobilenativefoundation.store.news.tooling.extensions.configureFlavors
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {

            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension> {
                compileSdk = Versions.COMPILE_SDK

                configureAndroidCompose(this)
                configureFlavors(this)
            }
        }
    }
}
