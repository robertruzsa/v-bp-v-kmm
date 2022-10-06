package com.robertruzsa.vbpvkmm.features.offers.domain.model
import kotlinx.serialization.Serializable

@Serializable
data class Route(
    val startLocation: Location = Location(),
    val endLocation: Location = Location()
)
