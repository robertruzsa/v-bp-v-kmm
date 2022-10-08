package com.robertruzsa.vbpvkmm.features.offers.data.mapper

import com.robertruzsa.vbpvkmm.common.util.datetime.DateTimeUtil
import com.robertruzsa.vbpvkmm.features.offers.data.dto.RideOfferCreateRequest
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

fun Offer.toApiModel(): RideOfferCreateRequest {
    return RideOfferCreateRequest(
        userId = "empty",
        route = RideOfferCreateRequest.Route(
            from = RideOfferCreateRequest.Route.Location(route.startLocation.name),
            to = RideOfferCreateRequest.Route.Location(route.endLocation.name)
        ),
        numberOfSeats = numberOfSeats,
        priceInHuf = priceInHuf,
        dateOfTravel = DateTimeUtil.toEpochMillis(dateOfTravel),
        dateOfPost = DateTimeUtil.toEpochMillis(DateTimeUtil.now())
    )
}
