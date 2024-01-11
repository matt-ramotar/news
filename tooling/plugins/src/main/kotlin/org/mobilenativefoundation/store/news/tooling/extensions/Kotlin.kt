package org.mobilenativefoundation.store.news.tooling.extensions

import org.gradle.api.Project
import org.mobilenativefoundation.store.news.tooling.extensions.configureJava

fun Project.configureKotlin() {
  configureJava()
}