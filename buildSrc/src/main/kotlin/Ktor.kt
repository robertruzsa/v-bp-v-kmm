object Ktor {
    private const val ktorVersion = "2.0.3"

    const val core = "io.ktor:ktor-client-core:$ktorVersion"
    const val clientSerialization = "io.ktor:ktor-client-serialization:$ktorVersion"
    const val android = "io.ktor:ktor-client-android:$ktorVersion"
    const val ios = "io.ktor:ktor-client-ios:$ktorVersion"
    const val logging = "io.ktor:ktor-client-logging:$ktorVersion"
    const val contentNegotiation = "io.ktor:ktor-client-content-negotiation:$ktorVersion"
    private const val logbackVersion = "1.2.3"
    const val logback = "ch.qos.logback:logback-classic:$logbackVersion"
    const val jsonSerialization = "io.ktor:ktor-serialization-kotlinx-json:$ktorVersion"
}
