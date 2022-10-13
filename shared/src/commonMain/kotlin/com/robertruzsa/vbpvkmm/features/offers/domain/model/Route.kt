package com.robertruzsa.vbpvkmm.features.offers.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Route(
    val startLocation: Location = Location(),
    val endLocation: Location = Location()
) {
    fun getDisplayText(default: String): String {
        return if (startLocation.name.isBlank() || endLocation.name.isBlank()) {
            default
        } else {
            "${startLocation.name} ➝ ${endLocation.name}"
        }
    }
}
