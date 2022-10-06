package com.robertruzsa.vbpvkmm.features.offers.domain.model

data class User(
    val name: String = "John Doe",
    val rating: Float = 4.5f,
    val numberOfRatings: Int = 12
) {
    val ratingWithNumberOfRatings
        get() = "$rating ($numberOfRatings)"
}
