package com.robertruzsa.vbpvkmm.features.offers.data.repository

import com.robertruzsa.vbpvkmm.common.network.TransportApi
import com.robertruzsa.vbpvkmm.features.offers.data.mapper.toApiModel
import com.robertruzsa.vbpvkmm.features.offers.data.mapper.toDomainModel
import com.robertruzsa.vbpvkmm.features.offers.domain.model.Offer
import com.robertruzsa.vbpvkmm.features.offers.domain.repository.RideOfferRepository

class RideOfferRepositoryImpl : RideOfferRepository {

    private val api = TransportApi()

    override suspend fun getAllRideOffers(): List<Offer> {
        return api.getAllOffers().toDomainModel()
    }

    override suspend fun createOffer(offer: Offer) {
        api.createRideOffer(offer.toApiModel())
    }
}
