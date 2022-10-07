object Compose {
    const val composeVersion = "1.2.1"
    const val composeCompilerVersion = "1.3.1"
    const val material = "androidx.compose.material:material:$composeVersion"
    const val ui = "androidx.compose.ui:ui:$composeVersion"
    const val uiTooling = "androidx.compose.ui:ui-tooling:$composeVersion"
    const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
    const val runtime = "androidx.compose.runtime:runtime:$composeVersion"
    const val compiler = "androidx.compose.compiler:compiler:$composeCompilerVersion"

    private const val navigationVersion = "2.4.0-beta02"
    const val navigation = "androidx.navigation:navigation-compose:$navigationVersion"

    private const val hiltNavigationComposeVersion = "1.0.0-beta01"
    const val hiltNavigationCompose =
        "androidx.hilt:hilt-navigation-compose:$hiltNavigationComposeVersion"

    private const val activityComposeVersion = "1.4.0"
    const val activityCompose = "androidx.activity:activity-compose:$activityComposeVersion"

    private const val lifecycleVersion = "2.4.0"
    const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion"

    private const val accompanistVersion = "0.26.4-beta"
    const val animatedNavigation =
        "com.google.accompanist:accompanist-navigation-animation:$accompanistVersion"
    const val systemUIController =
        "com.google.accompanist:accompanist-systemuicontroller:$accompanistVersion"

    const val extendedIcons = "androidx.compose.material:material-icons-extended:$composeVersion"

    const val liveData = "androidx.compose.runtime:runtime-livedata:$composeVersion"
}
