import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING
import java.util.Properties

plugins {
    id("plugin.store.news.android.library")
    id("plugin.store.news.kotlin.multiplatform")
    alias(libs.plugins.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.buildkonfig)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlinInject.runtime)
                api(libs.scoop.sdk.kotlin)
                api(projects.shared.lib.httpClient)
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
    namespace = "org.mobilenativefoundation.store.news.shared.lib.env"
}

buildkonfig {
    packageName = "org.mobilenativefoundation.store.news.shared.lib.env"

    val props = Properties()

    try {
        props.load(file("env.properties").inputStream())
    } catch (e: Exception) {
        println("Error loading env.properties: $e")
    }

    val scoopApiTokenKey = "SCOOP_API_TOKEN"

    defaultConfigs {
        buildConfigField(STRING, scoopApiTokenKey, props[scoopApiTokenKey].toString())
    }
}