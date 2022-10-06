package com.robertruzsa.vbpvkmm.features.offers.data.mapper

import com.robertruzsa.vbpvkmm.common.util.DateTimeUtil
import com.robertruzsa.vbpvkmm.features.offers.data.dto.RideOfferQueryResponse
import com.robertruzsa.vbpvkmm.features.offers.domain.model.Location
import com.robertruzsa.vbpvkmm.features.offers.domain.model.Offer
import com.robertruzsa.vbpvkmm.features.offers.domain.model.Route
import com.robertruzsa.vbpvkmm.features.offers.domain.model.User

fun RideOfferQueryResponse.toDomainModel(): List<Offer> {
    return offers.map {
        Offer(
            user = User(),
            dateOfPost = DateTimeUtil.toLocalDateTime(it.dateOfPost),
            dateOfTravel = DateTimeUtil.toLocalDateTime(it.dateOfTravel),
            numberOfSeats = it.numberOfSeats,
            priceInHuf = it.priceInHuf,
            route = Route(
                startLocation = Location(it.route.from.name),
                endLocation = Location(it.route.to.name)
            )
        )
    }
}
