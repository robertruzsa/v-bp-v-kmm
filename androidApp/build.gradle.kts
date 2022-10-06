import java.util.Properties

plugins {
    id(Plugins.androidApplication)
    id(Plugins.hilt)
    kotlin(KotlinPlugins.android)
    kotlin(KotlinPlugins.kapt)
    kotlin(KotlinPlugins.serialization) version Kotlin.version
}

android {
    namespace = ProjectConfig.appId
    compileSdk = ProjectConfig.compileSdk
    defaultConfig {
        applicationId = ProjectConfig.appId
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk
        versionCode = ProjectConfig.versionCode
        versionName = ProjectConfig.versionName

        val properties = Properties().apply {
            load(project.rootProject.file("local.properties").inputStream())
        }
        resValue(
            "string",
            "fb_app_id",
            properties.getProperty("fb_app_id")
        )
        resValue(
            "string",
            "fb_client_token",
            properties.getProperty("fb_client_token")
        )
        resValue(
            "string",
            "fb_login_protocol_scheme",
            properties.getProperty("fb_login_protocol_scheme")
        )
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(Compose.compiler)
    implementation(Compose.ui)
    implementation(Compose.uiToolingPreview)
    implementation(Compose.hiltNavigationCompose)
    implementation(Compose.material)
    implementation(Compose.runtime)
    implementation(Compose.navigation)
    implementation(Compose.viewModelCompose)
    implementation(Compose.activityCompose)
    implementation(Compose.animatedNavigation)
    implementation(Compose.extendedIcons)
    implementation(Compose.systemUIController)
    debugImplementation(Compose.uiTooling)

    implementation(Facebook.login)
    implementation(Facebook.androidSdk)

    kapt(Hilt.hiltCompiler)
    implementation(Hilt.hiltAndroid)

    implementation(Kotlinx.datetime)
    implementation(Ktor.android)
}
