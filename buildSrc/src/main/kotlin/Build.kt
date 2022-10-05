object Build {
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
    const val kotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:${Kotlin.version}"
    private const val gradlePluginVersion = "2.42"
    const val androidHiltGradlePlugin =
        "com.google.dagger:hilt-android-gradle-plugin:$gradlePluginVersion"
    private const val androidBuildToolsVersion = "7.1.3"
    const val androidBuildTools = "com.android.tools.build:gradle:$androidBuildToolsVersion"
}
