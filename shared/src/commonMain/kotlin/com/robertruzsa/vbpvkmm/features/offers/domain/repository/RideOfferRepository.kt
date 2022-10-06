package com.robertruzsa.vbpvkmm.features.offers.domain.repository

import com.robertruzsa.vbpvkmm.features.offers.domain.model.Offer

interface RideOfferRepository {
    suspend fun getAllRideOffers(): List<Offer>
}
