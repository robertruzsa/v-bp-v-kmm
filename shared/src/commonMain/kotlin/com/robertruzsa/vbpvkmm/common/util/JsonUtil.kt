package com.robertruzsa.vbpvkmm.common.util

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object JsonUtil {
    inline fun <reified T> toJsonString(obj: T): String = Json.encodeToString(obj)
    inline fun <reified T> fromJsonString(jsonString: String) = Json.decodeFromString<T>(jsonString)
}
