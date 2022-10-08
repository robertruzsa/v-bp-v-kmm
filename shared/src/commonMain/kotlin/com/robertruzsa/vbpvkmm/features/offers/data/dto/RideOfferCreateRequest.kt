package com.robertruzsa.vbpvkmm.features.offers.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class RideOfferCreateRequest(
    val userId: String,
    val dateOfTravel: Long,
    val route: Route,
    val priceInHuf: Int,
    val numberOfSeats: Int,
    val dateOfPost: Long
) {
    @Serializable
    data class Route(
        val from: Location,
        val to: Location
    ) {
        @Serializable
        data class Location(
            val name: String,
            val latitude: Double = .0,
            val longitude: Double = .0
        )
    }
}
