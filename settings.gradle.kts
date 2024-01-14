enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("tooling")

    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
    }
}

dependencyResolutionManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
    }
}

rootProject.name = "news"

// Android > App
include(":android:app")

// Shared > Core
include(":shared:core:di:api")
include(":shared:core:di:impl")
include(":shared:core:navigation:api")
include(":shared:core:navigation:impl")

// Shared > Feat
include(":shared:feat:homeTab:api")
include(":shared:feat:homeTab:impl")

// Shared > Lib
include(":shared:lib:composableModel")
include(":shared:lib:env")
include(":shared:lib:httpClient")
include(":shared:lib:res")
include(":shared:lib:scoop")
include(":shared:lib:theme")
