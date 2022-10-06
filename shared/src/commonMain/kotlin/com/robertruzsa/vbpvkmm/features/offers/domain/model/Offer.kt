package com.robertruzsa.vbpvkmm.features.offers.domain.model

import kotlinx.datetime.LocalDateTime

data class Offer(
    val user: User,
    val dateOfTravel: LocalDateTime,
    val dateOfPost: LocalDateTime,
    val route: Route,
    val numberOfSeats: Int,
    val priceInHuf: Int
)
