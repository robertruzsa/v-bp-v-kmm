package com.robertruzsa.vbpvkmm.features.offers.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class RideOfferQueryResponse(
    val offers: List<RideOffer>
) {
    @Serializable
    data class RideOffer(
        val id: Int,
        val route: Route,
        val userId: String,
        val dateOfTravel: Long,
        val dateOfPost: Long,
        val priceInHuf: Int,
        val numberOfSeats: Int
    ) {
        @Serializable
        data class Route(
            val from: Location,
            val to: Location
        ) {
            @Serializable
            data class Location(
                val name: String,
                val latitude: Double,
                val longitude: Double
            )
        }
    }
}
