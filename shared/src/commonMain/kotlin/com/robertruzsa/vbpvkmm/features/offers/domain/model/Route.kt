package com.robertruzsa.vbpvkmm.features.offers.domain.model

data class Route(
    val startLocation: Location = Location(),
    val endLocation: Location = Location()
)
