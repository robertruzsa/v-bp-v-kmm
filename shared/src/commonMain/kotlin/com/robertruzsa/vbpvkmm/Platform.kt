package com.robertruzsa.vbpvkmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform