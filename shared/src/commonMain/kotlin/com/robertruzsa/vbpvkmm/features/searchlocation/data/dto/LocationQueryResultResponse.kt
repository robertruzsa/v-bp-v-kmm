package com.robertruzsa.vbpvkmm.features.searchlocation.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class LocationQueryResultResponse(
    val locations: List<Location>
) {
    @Serializable
    data class Location(
        val name: String,
        val latitude: Double,
        val longitude: Double
    )
}
