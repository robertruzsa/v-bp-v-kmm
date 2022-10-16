package com.robertruzsa.vbpvkmm.features.offers.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Route(
    val startLocation: Location = Location(),
    val intermediateLocations: List<Location> = emptyList(),
    val endLocation: Location = Location()
) {

    val startOrEndFilled: Boolean
        get() = startLocation.name.isNotEmpty() || endLocation.name.isNotEmpty()

    fun getDisplayText(default: String): String {
        return if (startLocation.name.isBlank() || endLocation.name.isBlank()) {
            default
        } else {
            "${startLocation.name} ➝ ${endLocation.name}"
        }
    }
}
