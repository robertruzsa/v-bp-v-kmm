buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Build.kotlinGradlePlugin)
        classpath(Build.androidBuildTools)
        classpath(Build.androidHiltGradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
